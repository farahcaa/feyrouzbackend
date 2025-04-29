package us.feyrouzbackend.backend.model.Controllers;

import us.feyrouzbackend.backend.model.entities.User;
import jakarta.ws.rs.core.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import us.feyrouzbackend.backend.model.dto.SignUpDTO;
import us.feyrouzbackend.backend.model.dto.auth.LoginRequestDTO;
import us.feyrouzbackend.backend.model.entities.UserRepository;

import java.sql.Timestamp;

@Controller
public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public ResponseEntity<String> SignUP(@RequestBody SignUpDTO signupDTO) {
        User user = new User();
        user.setEmail(signupDTO.getEmail());
        user.setEmailUpdates(signupDTO.isEmailUpdates());
        user.setFirstName(signupDTO.getName().split(" ")[0]);
        user.setLastName(signupDTO.getName().split(" ")[1]);
        user.setPhone(signupDTO.getPhone());
        //todo add keycloak integration
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);

        return ResponseEntity.ok("hello");
    }
}
