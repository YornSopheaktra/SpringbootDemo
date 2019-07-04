package com.springboot.starter.processor;

import com.springboot.starter.domain.Entity.SysCampaign;
import com.springboot.starter.domain.dao.SysCampaignDao;
import com.springboot.starter.ws.request.RequestDTO;
import com.springboot.starter.ws.response.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
@Service
public class PromotionProcessor {
    @Autowired
    private SysCampaignDao sysCampaignDao;

    private Logger log = LoggerFactory.getLogger(PromotionProcessor.class);
    public ResponseDTO process(RequestDTO request, ResponseDTO response) {

        SysCampaign sysCampaign = sysCampaignDao.getSysCampaignById(Integer.valueOf(request.getData().get("promotionId").toString()));

        HashMap<String, Object> data = new HashMap<>();
        data.put("sysCampaign",sysCampaign);
        response.setData(data);
        return response;
    }
}
