package com.xworkz.onlineauction.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AuctionInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public AuctionInitializer(){
        System.out.println("created AuctionInitializer...");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AuctionConfiguration.class, WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
