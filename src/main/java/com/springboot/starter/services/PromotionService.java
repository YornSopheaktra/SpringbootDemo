package com.springboot.starter.services;

import com.springboot.starter.ws.request.RequestDTO;
import com.springboot.starter.ws.response.ResponseDTO;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public interface PromotionService {
    public ResponseDTO run(RequestDTO requestDTO);
}
