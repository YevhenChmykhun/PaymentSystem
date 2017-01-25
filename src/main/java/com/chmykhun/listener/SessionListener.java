package com.chmykhun.listener;

import com.chmykhun.service.VisitorService;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        VisitorService.checkInVisitor();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }

}
