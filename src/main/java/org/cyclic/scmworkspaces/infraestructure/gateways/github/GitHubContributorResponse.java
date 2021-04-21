package org.cyclic.scmworkspaces.infraestructure.gateways.github;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubContributorResponse {
    @JsonProperty("login")
    String login;
    @JsonProperty("contributions")
    int contributions;
}
