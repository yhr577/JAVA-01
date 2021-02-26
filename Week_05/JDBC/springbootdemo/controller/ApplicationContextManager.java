package com.rongsoft.springbootdemo.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextManager implements ApplicationContextAware {
    private ApplicationContext applicationContexts;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContexts = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContexts;
    }
}
