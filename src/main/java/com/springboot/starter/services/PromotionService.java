package com.springboot.starter.services;

import com.springboot.starter.ws.response.Response;

import javax.servlet.http.HttpServletRequest;

public interface PromotionService {
    public Response run(HttpServletRequest request);
}
