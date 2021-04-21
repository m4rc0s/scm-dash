package org.cyclic.scmworkspaces.core.model;

public class Repo {

    private final String owner;
    private final String name;

    public Repo(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
