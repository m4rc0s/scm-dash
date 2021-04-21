package org.cyclic.scmworkspaces.core;

import org.cyclic.scmworkspaces.application.dtos.RepoDTO;
import org.cyclic.scmworkspaces.application.dtos.WorkspaceDTO;
import org.cyclic.scmworkspaces.core.model.Repo;
import org.cyclic.scmworkspaces.core.model.Workspace;
import org.cyclic.scmworkspaces.data.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WorkspaceService {

    @Autowired
    WorkspaceRepository repository;

    public WorkspaceDTO create(String name) {
        Workspace workspace = repository.save(new Workspace(name));
        return WorkspaceDTO.of(workspace);
    }

    public WorkspaceDTO addRepo(String workspaceId, RepoDTO repo) throws Exception {
        Optional<Workspace> workspace = repository.findById(workspaceId);
        workspace.orElseThrow(Exception::new);
        workspace.get().repos.add(new Repo(repo.owner, repo.name));
        repository.save(workspace.get());
        return WorkspaceDTO.of(workspace.get());
    }

    public WorkspaceDTO findOne(String workspaceId) throws Exception {
        Optional<Workspace> workspace = repository.findById(workspaceId);
        workspace.orElseThrow(Exception::new);
        return WorkspaceDTO.of(workspace.get());
    }

}
