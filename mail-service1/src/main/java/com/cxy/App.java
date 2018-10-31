package com.cxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@RefreshScope
public class App{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private Environment environment;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "Hello "+ environment.getProperty("name");
    }

    @RequestMapping(value = "/hiDb", method = RequestMethod.GET)
    public String hiDb(){
        List<User> list = jdbcTemplate.query("select * from user",new Object[]{},new BeanPropertyRowMapper(User.class));
        String account = "";
        if(list!=null&& list.size()>0){
            account = list.get(0).getAccount();
        }
        return "Hello "+ account;
    }
}
