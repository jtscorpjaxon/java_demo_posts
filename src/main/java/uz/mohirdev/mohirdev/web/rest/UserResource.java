package uz.mohirdev.mohirdev.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.mohirdev.entity.User;
import uz.mohirdev.mohirdev.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user) {
        if (userService.existsByLogin(user.getLogin())) {
            return new ResponseEntity("Ahmoq", HttpStatus.BAD_REQUEST);
        }
        if (checkPassword(user.getPassword())) {
            return new ResponseEntity("Ahmoq parol", HttpStatus.BAD_REQUEST);

        }
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    private Boolean checkPassword(String password) {
        return password.length() <= 4;
    }
}
