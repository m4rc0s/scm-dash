package org.cyclic.scmworkspaces.github.gateway;

import org.cyclic.scmworkspaces.infraestructure.gateways.github.GitHubGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GitHubGatewayTest {

    private GitHubGateway gateway = new GitHubGateway("", "");


    @Test
    @DisplayName("should return repositories")
    void repositories() {

        assertThat(gateway.repositories()).isInstanceOf(String.class);

    }

}