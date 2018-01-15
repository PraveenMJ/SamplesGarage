package com.enterprise.test;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyApplication extends ResourceConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyApplication.class);
	
    public MyApplication() {
    	LOGGER.info("MyApplication constructed...");
        packages("com.enterprise.test.api;");
    }
    
}