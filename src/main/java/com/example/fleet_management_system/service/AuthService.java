package com.example.fleet_management_system.service;
import org.springframework.stereotype.Service;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.repository.UserRepository;

@Service
public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User validateUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }

        return null;
    }
    
}
