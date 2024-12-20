package uz.mohirdev.mohirdev.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.mohirdev.mohirdev.entity.User;
import uz.mohirdev.mohirdev.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean existsByLogin(String login){
        return userRepository.existsByLogin(login);
    }
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
