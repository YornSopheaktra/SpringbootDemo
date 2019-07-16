package com.springboot.starter.services.implement;

import com.springboot.starter.processor.PromotionProcessor;
import com.springboot.starter.services.PromotionService;
import com.springboot.starter.ws.request.RequestDTO;
import com.springboot.starter.ws.response.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
@Service
public class PromotionServiceImp implements PromotionService {

    private Logger log = LoggerFactory.getLogger(PromotionProcessor.class);

    @Autowired
    PromotionProcessor promotionProcessor;

    @Override
    public ResponseDTO run(RequestDTO request) {
        log.info("Request {} ", request.toString());
        ResponseDTO response = new ResponseDTO();
        try {

            return promotionProcessor.process(request,response);
        }catch (Exception e){
            log.error("",e);
        }finally {
            log.info("Respone{} ", response.toString());
        }
        return null;
    }
}
