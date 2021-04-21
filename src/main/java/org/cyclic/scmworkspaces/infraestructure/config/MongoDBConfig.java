package org.cyclic.scmworkspaces.infraestructure.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MongoDBConfig {

    public @Bean MongoClient mongoClient() {
        return MongoClients.create();
    }

}
