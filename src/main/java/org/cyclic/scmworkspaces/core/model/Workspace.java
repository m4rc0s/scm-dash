package org.cyclic.scmworkspaces.core.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Workspace {

    @Id
    public String id;

    public String name;

    public List<Repo> repos = new ArrayList<>();

    public Workspace(String name) {
        this.name = name;
    }

}
