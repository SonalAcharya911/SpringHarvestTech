package com.xworkz.contact.config;

import com.xworkz.contact.repository.ContactRepo;
import com.xworkz.contact.repository.ContactRepoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@ComponentScan(basePackages = "com.xworkz.contact")
public class ContactConfiguration {
    public ContactConfiguration(){
        System.out.println("created ContactConfiguration");
    }

    @Bean("dataSource")
    public DataSource getDataSource(){
        System.out.println("registering DataSource with Spring container");
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/contact_management");
        ds.setUsername("root");
        ds.setPassword("Sonal@7715");


        return ds;
    }

    @Bean("template")
    public JdbcTemplate getTemplate(){
        System.out.println("registering JdbcTemplate with Spring container");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean
    public ContactRepo getContactRepo(){
        System.out.println("registering ContactRepo with Spring container");
        ContactRepoImpl contactRepo =new ContactRepoImpl();
        contactRepo.setTemplate(getTemplate());
        return contactRepo;
    }

    @PostConstruct
    public void testDBConnection() {
        try (Connection conn = getDataSource().getConnection()) {
            System.out.println("✅ Connected to database: " + conn.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
