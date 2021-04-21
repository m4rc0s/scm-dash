package org.cyclic.scmworkspaces.infraestructure.gateways.github;

import feign.*;
import feign.jackson.JacksonDecoder;

import java.util.List;

interface GitHubClient {
    @RequestLine("GET /user/repos")
    @Headers("Authorization: token {token}")
    List<GitHubRepositoryResponse> repositories(@Param("token") String authToken);

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<GitHubContributorResponse> contributors(@Param("owner") String owner, @Param("repo") String repo);
}

public class GitHubGateway {

    private final String baseUrl;
    private final String token;

    public GitHubGateway(String baseUrl, String token) {
        this.baseUrl = baseUrl;
        this.token = token;
    }

    public List<GitHubRepositoryResponse> repositories() {
        GitHubClient client = Feign.builder().decoder(new JacksonDecoder())
                .target(GitHubClient.class, this.baseUrl);

        return client.repositories(this.token);
    }

    public List<GitHubContributorResponse> contributors(String owner, String repo) {
        GitHubClient github = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(GitHubClient.class, this.baseUrl);

        return github.contributors(owner, repo);
    }


}
