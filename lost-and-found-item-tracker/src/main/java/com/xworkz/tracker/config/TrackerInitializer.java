package com.xworkz.tracker.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TrackerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public TrackerInitializer(){
        System.out.println("created TrackerInitializer...");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("running getRootConfigClasses");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("running getServletConfigClasses");
        return new Class[]{TrackerConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("running getServletMappings");
        return new String[]{"/"};
    }
}
