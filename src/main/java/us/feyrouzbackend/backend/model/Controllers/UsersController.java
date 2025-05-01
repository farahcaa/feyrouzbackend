package us.feyrouzbackend.backend.model.Controllers;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import us.feyrouzbackend.backend.model.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import us.feyrouzbackend.backend.model.dto.SignUpDTO;
import us.feyrouzbackend.backend.model.entities.UserRepository;

import java.sql.Timestamp;
import java.util.Collections;

@Controller
public class UsersController {
    private final UserRepository userRepository;
    private final Keycloak keycloak;
    public UsersController(UserRepository userRepository, Keycloak keycloak) {
        this.userRepository = userRepository;
        this.keycloak = keycloak;
    }

    @PostMapping("/user")
    public ResponseEntity<String> SignUP(@RequestBody SignUpDTO signupDTO) {
        // Create Keycloak User
        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(signupDTO.getEmail());
        kcUser.setEmail(signupDTO.getEmail());
        kcUser.setFirstName(signupDTO.getName().split(" ")[0]);
        kcUser.setLastName(signupDTO.getName().split(" ")[1]);
        kcUser.setEnabled(true);

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(signupDTO.getPassword()); // Assume password is in DTO

        kcUser.setCredentials(Collections.singletonList(credential));

        // Create user in Keycloak
        RealmResource realm = keycloak.realm("myrealm");
        realm.users().create(kcUser);

        // Create user in your database
        User user = new User();
        user.setEmail(signupDTO.getEmail());
        user.setEmailUpdates(signupDTO.isEmailUpdates());
        user.setFirstName(signupDTO.getName().split(" ")[0]);
        user.setLastName(signupDTO.getName().split(" ")[1]);
        user.setPhone(signupDTO.getPhone());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);

        return ResponseEntity.ok("User created in DB and Keycloak");
    }
}
