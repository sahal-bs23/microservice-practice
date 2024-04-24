package com.practice.moviecatalogservice.controller;

import com.practice.moviecatalogservice.model.DbSettings;
import freemarker.core.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class GretingController {

    @Value("${my.greeting: hakahaki}")
    private String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Autowired
//    private Environment environment;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting() {
        return dbSettings.getConnection() + " " + dbSettings.getHost() + " " + dbSettings.getPort() + " " + greetingMessage;
    }

//    @GetMapping("/envdetails")
//    public String envDetails() {
//        return environment.g
//    }

}
