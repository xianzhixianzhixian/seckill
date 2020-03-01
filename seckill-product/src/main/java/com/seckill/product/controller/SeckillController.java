package com.seckill.product.controller;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.constant.SeckillGeneralCodeMapping;
import com.seckill.common.constant.SeckillReturnCodeMapping;
import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.Event;
import com.seckill.product.event.entity.SeckillProductEvent;
import com.seckill.product.event.handler.CentralEventForwardHandler;
import com.seckill.product.event.state.SeckillEventType;
import com.seckill.product.service.SeckillProductService;
import com.seckill.product.service.feign.SeckillMessageFeignService;
import com.seckill.product.service.impl.SeckillProductIntegrationServiceImpl;
import com.seckill.product.service.impl.SeckillServiceImpl;
import com.seckill.product.service.impl.SeckillUserResultServiceImpl;
import com.seckill.product.strategy.SeckillProductAOPStrategy;
import com.seckill.product.strategy.SeckillProductFutureStrategy;
import com.seckill.product.strategy.SeckillProductStrategy;
import com.seckill.product.util.RedissonLockUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    @Autowired
    private SeckillServiceImpl seckillService;
    @Autowired
    private SeckillProductService seckillProductService;
    @Autowired
    private SeckillProductIntegrationServiceImpl seckillProductIntegrationService;
    @Autowired
    private SeckillMessageFeignService seckillMessageFeignService;
    @Autowired
    private SeckillUserResultServiceImpl seckillUserResultService;
    @Autowired
    private RedissonLockUtil redissonLockUtil;
    private SeckillProductStrategy seckillProductStrategy;
    private CentralEventForwardHandler centralEventForwardHandler;
    private CentralEventProcessor centralEventProcessor;

    @ResponseBody
    @PostMapping("/seckillProductAOP")
    public SeckillResult seckillProductAOP(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        try {
            Integer seckillNum = seckillService.seckillProductAOP(userId, shopId, seckillProductId);
            if (seckillNum == 0) {
                return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "商品已经卖完了哦！");
            } else {
                return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "抢购成功！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, "系统错误", e);
        }
    }

    @ResponseBody
    @PostMapping("/multipltThreadSeckillProduct")
    public void multipltThreadSeckillProduct(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        seckillService.multipltThreadSeckillProduct(userId, seckillProductId);
    }

    @ResponseBody
    @PostMapping("/seckillProductPessimisticLock")
    public SeckillResult seckillProductPessimisticLock(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        Integer seckillResultNum = seckillService.seckillProductPessimisticLock(userId, seckillProductId);
        if (seckillResultNum == 0) {
            return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "商品已经卖完了哦");
        }
        return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "恭喜抢到商品");
    }

    @ResponseBody
    @PostMapping("/seckillProductOptimisticLock")
    public SeckillResult seckillProductOptimisticLock(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        Integer seckillResultNum = seckillService.seckillProductOptimisticLock(userId, seckillProductId);
        if (seckillResultNum == 0) {
            return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "商品已经卖完了哦");
        }
        return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "恭喜抢到商品");
    }

    @ResponseBody
    @PostMapping("/seckillProductQueueAndThread")
    public void seckillProductQueueAndThread(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        seckillService.seckillProductQueueAndThread(userId, seckillProductId);
    }

    @ResponseBody
    @PostMapping("/seckillProductRedisLock")
    public SeckillResult seckillProductRedisLock(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        Integer seckillResultNum = seckillService.seckillProductRedisLock(userId, seckillProductId);
        if (seckillResultNum == 0) {
            return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "商品已经卖完了哦");
        }
        return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "恭喜抢到商品");
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

    @ResponseBody
    @PostMapping("/seckillProductStrategy")
    public Integer seckillProductStrategy(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(userId);
        seckillOrder.setShopId(shopId);
        seckillOrder.setSeckillProductId(seckillProductId);
        SeckillUserResult seckillUserResult = new SeckillUserResult();
        seckillUserResult.setUserId(userId);
        seckillUserResult.setSeckillProductId(seckillProductId);
        return seckillProductStrategy.seckillProduct(seckillProduct, seckillOrder, seckillUserResult);
    }

    @ResponseBody
    @PostMapping("/seckillProductEvent")
    public SeckillResult seckillProductEvent(@RequestParam("userId") Long userId, @RequestParam("shopId") Long shopId, @RequestParam("seckillProductId") Long seckillProductId) {
        try {
            SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
            if (seckillProduct == null) {
                return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "秒杀商品不存在");
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
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, "系统错误", e);
        }
        return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "正在抢购");
    }

    @PostMapping("/selectSeckillUserResultByUserId")
    public SeckillResult selectSeckillUserResultByUserId(Long userId) {
        try {
            List<SeckillUserResult> seckillUserResultList = seckillUserResultService.selectSeckillUserResultByUserId(userId);
            return new SeckillResult(seckillUserResultList);
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, "系统错误", e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //通过Redis进行实时切换秒杀策略
        String strategy = redissonLockUtil.getFromBucket(SeckillGeneralCodeMapping.SECKILL_STRATEGY);
        //默认使用Future策略分布式锁
        if (StringUtils.isEmpty(strategy)) {
            seckillProductStrategy = new SeckillProductFutureStrategy(seckillProductIntegrationService);
        } else {
            if (SeckillGeneralCodeMapping.SECKILL_STRATEGY_FUTURE.equals(strategy)) {
                //Future策略分布式锁
                seckillProductStrategy = new SeckillProductFutureStrategy(seckillProductIntegrationService);
            } else if (SeckillGeneralCodeMapping.SECKILL_STRATEGY_AOP_LOCK.equals(strategy)) {
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
