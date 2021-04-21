package org.cyclic.scmworkspaces.data;

import org.cyclic.scmworkspaces.core.model.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkspaceRepository extends MongoRepository<Workspace, String> { }
