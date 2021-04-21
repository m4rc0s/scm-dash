package org.cyclic.scmworkspaces.infraestructure.config;

import org.cyclic.scmworkspaces.infraestructure.gateways.github.GitHubGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitHubGatewayConfig {

    @Value("${github-api.base-url}")
    private String baseUrl;

    @Value("${github-api.token}")
    private String token;

    @Bean
    public GitHubGateway githubGateway() {
        return new GitHubGateway(baseUrl, token);
    }

}
