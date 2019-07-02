package com.springboot.starter.ws.request;

import com.springboot.starter.utils.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
public class RequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String requestId;
    private Integer accountId;
    private String sessionId;
    private Date date;
    private HashMap<String,Object> data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString(){
        String res;
        res= ToString.pgson.toJson(this);
        return res;
    }
}
