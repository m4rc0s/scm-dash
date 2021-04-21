package org.cyclic.scmworkspaces.infraestructure.gateways.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubRepoOwnerResponse {

    @JsonProperty("name")
    public String login;

    public GitHubRepoOwnerResponse(@JsonProperty("login") String login){
        this.login = login;
    }
}
