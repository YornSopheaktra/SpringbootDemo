package com.springboot.starter.utils;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
@ConditionalOnClass(ApplicationContext.class)
@Component("applicationContextProvider")
public final class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext appContext = null;

    public static ApplicationContext getAppContext() {
        return appContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        try {
            return appContext != null ? appContext.getBean(beanClass) : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T getBean(String beanName) {
        try {
            return (T) getAppContext().getBean(beanName);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.appContext = applicationContext;
    }

}
