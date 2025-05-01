package us.feyrouzbackend.backend.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    @Bean
    public Keycloak keycloakAdminClient() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8070")
                .realm("feyrouz") // Realm to authenticate as admin
                .clientId("feyrouz")
                .username("admin") // Keycloak admin
                .password("admin") // Keycloak admin password
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }
}