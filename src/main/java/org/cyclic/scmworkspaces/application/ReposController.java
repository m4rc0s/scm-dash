package org.cyclic.scmworkspaces.application;

import org.cyclic.scmworkspaces.application.dtos.RepoDTO;
import org.cyclic.scmworkspaces.infraestructure.gateways.github.GitHubContributorResponse;
import org.cyclic.scmworkspaces.infraestructure.gateways.github.GitHubGateway;
import org.cyclic.scmworkspaces.infraestructure.gateways.github.GitHubRepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/repos")
public class ReposController {

    @Autowired
    private GitHubGateway gitHubGateway;

    @GetMapping
    public List<RepoDTO> getRepositories() {
        List<GitHubRepositoryResponse> repositories = gitHubGateway.repositories();
        List<RepoDTO> res = new ArrayList<>();

        for(GitHubRepositoryResponse repo : repositories) {
            res.add(new RepoDTO(repo.getOwner().login, repo.getName()));
        }

        return res;
    }

    @GetMapping("/{owner}/{repo}/contributors")
    public List<GitHubContributorResponse> getContributors(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    ) {
        return gitHubGateway.contributors(owner, repo);
    }

}
