package com.seckill.manager.shop.controller;

import com.seckill.common.bean.ManagerShop;
import com.seckill.manager.shop.service.impl.ShopServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@RequestMapping("/shop")
@Controller
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @RequestMapping(value = "/toApplyShop", method = RequestMethod.GET)
    public String toApplyShop(){
        return "toApplyShop";
    }

    @RequestMapping(value = "/applyShop", method = RequestMethod.POST)
    public String applyShop(ManagerShop shopInfo, Model model){
        if(StringUtils.isBlank(shopInfo.getShopName())){
            model.addAttribute("error","店铺名称不能为空");
            return "toApplyShop";
        }
        if(StringUtils.isBlank(shopInfo.getShopBussinessScope())){
            model.addAttribute("error","店铺经营范围不能为空");
            return "toApplyShop";
        }
        if(StringUtils.isBlank(shopInfo.getBusinessLicense())){
            model.addAttribute("error","店铺营业执照不能为空");
            return "toApplyShop";
        }
        try {
            shopService.addShopInfo(shopInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewMerchant";
    }

    @RequestMapping(value = "/toSearchShop", method = RequestMethod.GET)
    public String toSearchShop(){
        return "toSearchShop";
    }

    @RequestMapping(value = "/searchShop", method = RequestMethod.POST)
    public String searchShop(ManagerShop shopInfo, Model model){
        List<ManagerShop> listShop = shopService.listShopInfoBy(shopInfo);
        model.addAttribute("listShop",listShop);
        return "listShop";
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.GET)
    public String updateState(Long id, Integer state){
        ManagerShop shopInfo = new ManagerShop();
        shopInfo.setId(id);
        shopInfo.setState(state);
        shopService.updateShopInfoSelective(shopInfo);
        return "listShop";
    }

}
