package com.Activity.sysarch.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://arvinceramos:2019028512@sysarch.rsjhgni.mongodb.net/arvinceramos?retryWrites=true&w=majority&appName=sysarch");
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(connectionString), "arvinceramos");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
