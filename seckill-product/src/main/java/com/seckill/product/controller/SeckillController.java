package com.seckill.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.constant.SeckillGeneralCodeType;
import com.seckill.common.constant.SeckillReturnCodeType;
import com.seckill.common.entity.PaymentParam;
import com.seckill.common.entity.event.Event;
import com.seckill.common.entity.event.type.SeckillEventType;
import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.OrderEvent;
import com.seckill.product.event.entity.SeckillProductEvent;
import com.seckill.product.event.handler.CentralEventForwardHandler;

import com.seckill.product.service.SeckillProductService;
import com.seckill.product.service.feign.SeckillMessageFeignService;
import com.seckill.product.service.feign.SeckillPaymentFeignService;
import com.seckill.product.service.impl.SeckillProductIntegrationServiceImpl;
import com.seckill.product.service.impl.SeckillServiceImpl;
import com.seckill.product.service.impl.SeckillUserResultServiceImpl;
import com.seckill.product.strategy.SeckillProductAOPStrategy;
import com.seckill.product.strategy.SeckillProductFutureStrategy;
import com.seckill.product.strategy.SeckillProductStrategy;
import com.seckill.product.util.RedissonLockUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.BlockingDeque;

@RestController
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(SeckillController.class);

    @Autowired
    private SeckillServiceImpl seckillService;
    @Autowired
    private SeckillProductService seckillProductService;
    @Autowired
    private SeckillProductIntegrationServiceImpl seckillProductIntegrationService;
    @Autowired
    private SeckillMessageFeignService seckillMessageFeignService;
    @Autowired
    private SeckillPaymentFeignService seckillPaymentFeignService;
    @Autowired
    private SeckillUserResultServiceImpl seckillUserResultService;
    @Autowired
    private RedissonLockUtil redissonLockUtil;
    private SeckillProductStrategy seckillProductStrategy;
    private CentralEventForwardHandler centralEventForwardHandler;
    private CentralEventProcessor centralEventProcessor;

    @HystrixCommand(fallbackMethod =  "seckillProductAOPFail")
    @ResponseBody
    @PostMapping("/seckillProductAOP")
    public SeckillResult seckillProductAOP(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        try {
            Integer seckillNum = seckillService.seckillProductAOP(userId, shopId, seckillProductId);
            if (seckillNum == 0) {
                return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "商品已经卖完了哦！");
            } else {
                return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "抢购成功！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "系统错误", e);
        }
    }

    public SeckillResult seckillProductAOPFail(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "seckillProductAOP熔断降级");
    }

    @ResponseBody
    @PostMapping("/multipltThreadSeckillProduct")
    public void multipltThreadSeckillProduct(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        seckillService.multipltThreadSeckillProduct(userId, seckillProductId);
    }

    @HystrixCommand(fallbackMethod = "seckillProductPessimisticLockFail")
    @ResponseBody
    @PostMapping("/seckillProductPessimisticLock")
    public SeckillResult seckillProductPessimisticLock(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        Integer seckillResultNum = seckillService.seckillProductPessimisticLock(userId, seckillProductId);
        if (seckillResultNum == 0) {
            return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "商品已经卖完了哦");
        }
        return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "恭喜抢到商品");
    }

    public SeckillResult seckillProductPessimisticLockFail(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "seckillProductPessimisticLock熔断降级");
    }

    @HystrixCommand(fallbackMethod = "seckillProductOptimisticLockFail")
    @ResponseBody
    @PostMapping("/seckillProductOptimisticLock")
    public SeckillResult seckillProductOptimisticLock(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        Integer seckillResultNum = seckillService.seckillProductOptimisticLock(userId, seckillProductId);
        if (seckillResultNum == 0) {
            return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "商品已经卖完了哦");
        }
        return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "恭喜抢到商品");
    }

    public SeckillResult seckillProductOptimisticLockFail(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "seckillProductOptimisticLock熔断降级");
    }

    @ResponseBody
    @PostMapping("/seckillProductQueueAndThread")
    public void seckillProductQueueAndThread(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        seckillService.seckillProductQueueAndThread(userId, seckillProductId);
    }

    @HystrixCommand(fallbackMethod = "seckillProductRedisLockFail")
    @ResponseBody
    @PostMapping("/seckillProductRedisLock")
    public SeckillResult seckillProductRedisLock(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        Integer seckillResultNum = seckillService.seckillProductRedisLock(userId, seckillProductId);
        if (seckillResultNum == 0) {
            return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "商品已经卖完了哦");
        }
        return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "恭喜抢到商品");
    }

    public SeckillResult seckillProductRedisLockFail(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "seckillProductRedisLock熔断降级");
    }

    @ResponseBody
    @PostMapping("/seckillProductFutrue")
    public void seckillProductFutrue(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        seckillService.seckillProductFutrue(userId, seckillProductId);
    }

    @ResponseBody
    @PostMapping("/seckillProductDistributeFuture")
    public void seckillProductDistributeFuture(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(userId);
        seckillOrder.setShopId(shopId);
        seckillOrder.setSeckillProductId(seckillProductId);
        SeckillUserResult seckillUserResult = new SeckillUserResult();
        seckillUserResult.setUserId(userId);
        seckillUserResult.setSeckillProductId(seckillProductId);
        seckillProductIntegrationService.seckillProductDistributeFuture(seckillProduct, seckillOrder, seckillUserResult);
    }

    @HystrixCommand(fallbackMethod = "seckillProductStrategyFail")
    @ResponseBody
    @PostMapping("/seckillProductStrategy")
    public SeckillResult seckillProductStrategy(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(userId);
        seckillOrder.setShopId(shopId);
        seckillOrder.setSeckillProductId(seckillProductId);
        SeckillUserResult seckillUserResult = new SeckillUserResult();
        seckillUserResult.setUserId(userId);
        seckillUserResult.setSeckillProductId(seckillProductId);
        Integer result = 0;
        try {
            result = seckillProductStrategy.seckillProduct(seckillProduct, seckillOrder, seckillUserResult);
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "策略模式秒杀成功", result);
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "策略模式秒杀错误", e);
        }
    }

    public SeckillResult seckillProductStrategyFail(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "seckillProductStrategy熔断降级");
    }

    @HystrixCommand(fallbackMethod = "seckillProductEventFail")
    @ResponseBody
    @PostMapping("/seckillProductEvent")
    public SeckillResult seckillProductEvent(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        try {
            SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
            if (seckillProduct == null) {
                return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "秒杀商品不存在");
            }
            SeckillOrder seckillOrder = new SeckillOrder();
            seckillOrder.setUserId(userId);
            seckillOrder.setShopId(shopId);
            seckillOrder.setSeckillProductId(seckillProductId);
            SeckillUserResult seckillUserResult = new SeckillUserResult();
            seckillUserResult.setUserId(userId);
            seckillUserResult.setSeckillProductId(seckillProductId);
            Event seckillEvent = new SeckillProductEvent(
                    "multipltThreadSeckillProduct",
                    SeckillEventType.NEW,
                    seckillProduct,
                    seckillOrder,
                    seckillUserResult,
                    seckillService,
                    seckillUserResultService,
                    seckillProductStrategy,
                    seckillMessageFeignService
            );
            centralEventForwardHandler.handler(seckillEvent);
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "系统错误", e);
        }
        return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "正在抢购");
    }

    public SeckillResult seckillProductEventFail(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "seckillProductEvent熔断降级");
    }

    @HystrixCommand(fallbackMethod = "selectSeckillUserResultByUserIdFail")
    @PostMapping("/selectSeckillUserResultByUserId")
    public SeckillResult selectSeckillUserResultByUserId(Long userId) {
        try {
            List<SeckillUserResult> seckillUserResultList = seckillUserResultService.selectSeckillUserResultByUserId(userId);
            return new SeckillResult(seckillUserResultList);
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "系统错误", e);
        }
    }

    public SeckillResult selectSeckillUserResultByUserIdFail(Long userId) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "selectSeckillUserResultByUserId熔断降级");
    }

    @HystrixCommand(fallbackMethod = "sendEventFail")
    @PostMapping("/sendEvent")
    public SeckillResult sendEvent(@RequestBody Event event) {
        logger.info("sendEvent接收到event{}", event);
        try {
            OrderEvent orderEvent = new OrderEvent();
            orderEvent.setName(event.getName());
            orderEvent.setEventType(event.getEventType());
            orderEvent.setSeckillProduct(event.getSeckillProduct());
            orderEvent.setSeckillOrder(event.getSeckillOrder());
            orderEvent.setSeckillUserResult(event.getSeckillUserResult());
            orderEvent.setSeckillService(seckillService);
            orderEvent.setSeckillMessageFeignService(seckillMessageFeignService);
            orderEvent.setSeckillProductStrategy(seckillProductStrategy);
            orderEvent.setSeckillUserResultService(seckillUserResultService);
            BlockingDeque<Event> eventBlockingDeque = centralEventProcessor.getCentralEventQueue();
            eventBlockingDeque.put(orderEvent);
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "事件发送成功");
        } catch (Exception e) {
            logger.error("sendEvent发生错误，原因{}", e);
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "接收事件错误", e);
        }
    }

    public SeckillResult sendEventFail(@RequestBody Event event) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "sendEvent熔断降级");
    }

    @HystrixCommand(fallbackMethod = "payForOrderFail")
    @PostMapping("/payForOrder")
    public SeckillResult payForOrder(@RequestBody PaymentParam paymentParam) {
        return seckillPaymentFeignService.payForOrder(paymentParam);
    }

    public SeckillResult payForOrderFail(@RequestBody PaymentParam paymentParam) {
        return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "payForOrder熔断降级");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //通过Redis进行实时切换秒杀策略
        String strategy = redissonLockUtil.getFromBucket(SeckillGeneralCodeType.SECKILL_STRATEGY);
        //默认使用Future策略分布式锁
        if (StringUtils.isEmpty(strategy)) {
            seckillProductStrategy = new SeckillProductFutureStrategy(seckillProductIntegrationService);
        } else {
            if (SeckillGeneralCodeType.SECKILL_STRATEGY_FUTURE.equals(strategy)) {
                //Future策略分布式锁
                seckillProductStrategy = new SeckillProductFutureStrategy(seckillProductIntegrationService);
            } else if (SeckillGeneralCodeType.SECKILL_STRATEGY_AOP_LOCK.equals(strategy)) {
                //AOP策略非分布式锁
                seckillProductStrategy = new SeckillProductAOPStrategy(seckillService);
            }
        }
        //事件存储队列
        centralEventProcessor = new CentralEventProcessor();
        //事件处理器
        centralEventForwardHandler = new CentralEventForwardHandler(centralEventProcessor);
    }
}
