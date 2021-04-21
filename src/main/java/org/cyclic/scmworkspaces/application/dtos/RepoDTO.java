package org.cyclic.scmworkspaces.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepoDTO {

    @JsonProperty("owner")
    public String owner;

    @JsonProperty("name")
    public String name;

    public RepoDTO(@JsonProperty("owner") String owner, @JsonProperty("name") String name) {
        this.owner = owner;
        this.name = name;
    }
}
