package org.cyclic.scmworkspaces.infraestructure.gateways.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubRepositoryResponse {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("owner")
    GitHubRepoOwnerResponse owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GitHubRepoOwnerResponse getOwner() {
        return owner;
    }

    public void setOwner(GitHubRepoOwnerResponse owner) {
        this.owner = owner;
    }

    public GitHubRepositoryResponse(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("owner") GitHubRepoOwnerResponse owner
    ) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

}
