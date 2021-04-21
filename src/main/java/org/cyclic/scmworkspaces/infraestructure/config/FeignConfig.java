package org.cyclic.scmworkspaces.infraestructure.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${github-api.token}")
    private String token;

    @Bean
    AuthInterceptor authFeign() {
        return new AuthInterceptor();
    }

    class AuthInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            template.header("Authorization", "token " + token);

        }

    }
}
