package com.xworkz.contact.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContactInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public ContactInitializer(){
        System.out.println("created ContactInitializer...");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ContactConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/submit"};
    }
}
