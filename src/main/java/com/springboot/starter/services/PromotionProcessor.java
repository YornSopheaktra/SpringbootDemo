package com.springboot.starter.services;

import com.springboot.starter.ws.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
public class PromotionProcessor {

    private Logger log = LoggerFactory.getLogger(PromotionProcessor.class);
    public Response process(HttpServletRequest request, Response response) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("Aplouk", "Jorm");
        data.put("dfs", "Jorm");
        data.put("erer", "Jorm");
        data.put("ewwe", "Jorm");
        data.put("dsf", "Jorm");
        data.put("eerr", "Jorm");
        data.put("sfdx", "Jorm");
        data.put("trtr", "Jorm");
        data.put("wwwer", "Jorm");

        HashMap<String, Object> data1 = new HashMap<>();

        data1.put("data",data);

        log.info("data1====={}",data1);
        response.setData(data1);
        log.error("res {}", response);
        return response;
    }
}
