package us.feyrouzbackend.backend.model.Controllers;

import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import us.feyrouzbackend.backend.model.dto.auth.LoginRequestDTO;

@Controller("/Auth")
public class AuthController {

    Keycloak keyCloak = KeycloakBuilder.builder().serverUrl("http://localhost:8080/auth").realm("feyrouz").clientId("feyrouz").clientSecret("feyrouz").username("admin").password("admin").build();
    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequest) {
        return ResponseEntity.ok("hello");
    }
}
