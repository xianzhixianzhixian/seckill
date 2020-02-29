package com.seckill.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by li on 2019/3/21.
 */
public class TradeSeqNumberUtils {

    /**
     * 获取交易流水号
     * @return
     */
    public static String getTradeSeqNummber(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String timestmap = dateFormat.format(new Date());
        String result = UUID.randomUUID() + timestmap;
        return result;
    }
}
