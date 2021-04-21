package org.cyclic.scmworkspaces.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cyclic.scmworkspaces.core.model.Repo;
import org.cyclic.scmworkspaces.core.model.Workspace;

import java.util.ArrayList;
import java.util.List;

public class WorkspaceDTO {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("repos")
    public List<RepoDTO> repos = new ArrayList<>();

    public WorkspaceDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

    public static WorkspaceDTO of(Workspace workspace) {
        WorkspaceDTO dto = new WorkspaceDTO(workspace.name);
        dto.id = workspace.id;
        dto.name = workspace.name;

        for (Repo item : workspace.repos) {
            dto.repos.add(new RepoDTO(item.getOwner(), item.getName()));
        }

        return dto;
    }
}