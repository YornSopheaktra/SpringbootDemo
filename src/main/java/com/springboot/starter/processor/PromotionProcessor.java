package com.springboot.starter.processor;

import com.springboot.starter.domain.Entity.SysCampaign;
import com.springboot.starter.domain.dao.SysCampaignDao;
import com.springboot.starter.ws.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
public class PromotionProcessor {
    @Autowired
    private SysCampaignDao sysCampaignDao;

    private Logger log = LoggerFactory.getLogger(PromotionProcessor.class);
    public Response process(HttpServletRequest request, Response response) {

        SysCampaign sysCampaign = sysCampaignDao.getSysCampaignById(1);

        HashMap<String, Object> data = new HashMap<>();
        data.put("sysCampaign",sysCampaign);
        response.setData(data);
        log.error("res {}", response);
        return response;
    }
}
