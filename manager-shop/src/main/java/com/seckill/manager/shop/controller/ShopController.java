package com.seckill.manager.shop.controller;

import com.seckill.common.bean.ManagerShop;
import com.seckill.common.request.SeckillCodeMapping;
import com.seckill.common.request.SeckillResult;
import com.seckill.manager.shop.service.impl.ShopServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopServiceImpl shopService;

    @PostMapping("/applyShop")
    public SeckillResult applyShop(@RequestBody ManagerShop shopInfo){
        if (StringUtils.isEmpty(shopInfo.getShopName())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "店铺名称不能为空");
        }
        if (StringUtils.isEmpty(shopInfo.getShopBussinessScope())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "店铺经营范围不能为空");
        }
        if (StringUtils.isEmpty(shopInfo.getBusinessLicense())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "店铺营业执照不能为空");
        }
        try {
            return new SeckillResult(shopService.addShopInfo(shopInfo));
        } catch (Exception e) {
            logger.error("添加商店信息错误，原因{}", e);
            return new SeckillResult(SeckillCodeMapping.SYSTEM_ERROR, "添加商店信息错误", e);
        }
    }

    @PostMapping("/searchShop")
    public SeckillResult searchShop(@RequestBody ManagerShop shopInfo){
        if (StringUtils.isEmpty(shopInfo.getShopName())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "店铺名称不能为空");
        }
        if (shopInfo.getState() == null) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "店铺状态不能为空");
        }
        return new SeckillResult(shopService.listShopInfoBy(shopInfo));
    }

    @PostMapping("/updateState")
    public SeckillResult updateState(Long id, Integer state){
        ManagerShop shopInfo = new ManagerShop();
        shopInfo.setId(id);
        shopInfo.setState(state);
        return new SeckillResult(shopService.updateShopInfoSelective(shopInfo));
    }

}
