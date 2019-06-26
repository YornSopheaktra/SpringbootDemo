package com.springboot.starter.services.implement;

import com.springboot.starter.processor.PromotionProcessor;
import com.springboot.starter.services.PromotionService;
import com.springboot.starter.ws.response.Response;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PromotionServiceImp implements PromotionService {

    private Logger log = LoggerFactory.getLogger(PromotionProcessor.class);

    @Autowired
    PromotionProcessor promotionProcessor;

    @Override
    public Response run(HttpServletRequest request) {
        log.info("Request {} ", request.getHeaderNames());
        Response response = new Response();
        try {

            return promotionProcessor.process(request,response);
        }catch (Exception e){
            log.error("",e);
        }finally {
            log.info("Respone{} ", response.toString());
            log.debug("response {}",response.toString());
        }
        return null;
    }
}
