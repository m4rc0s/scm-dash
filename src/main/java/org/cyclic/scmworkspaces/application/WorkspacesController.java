package org.cyclic.scmworkspaces.application;

import org.cyclic.scmworkspaces.application.dtos.RepoDTO;
import org.cyclic.scmworkspaces.application.dtos.WorkspaceDTO;
import org.cyclic.scmworkspaces.core.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workspaces")
public class WorkspacesController {

    @Autowired
    WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<WorkspaceDTO> create(@RequestBody WorkspaceDTO body) {
        WorkspaceDTO response = workspaceService.create(body.name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("{workspaceId}")
    public ResponseEntity<WorkspaceDTO> addRepo(
            @PathVariable String workspaceId,
            @RequestBody RepoDTO body
    ) throws Exception {
        WorkspaceDTO response = workspaceService.addRepo(workspaceId, body);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{workspaceId}")
    @CrossOrigin
    public ResponseEntity<WorkspaceDTO> findOne(@PathVariable String workspaceId) throws Exception {
        WorkspaceDTO response = workspaceService.findOne(workspaceId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
