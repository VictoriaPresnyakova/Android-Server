package com.server.server.Service;



import com.server.server.Controller.DTO.UserDTO;
import com.server.server.Model.Order;
import com.server.server.Model.User;
import com.server.server.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User signIn(String email, String password){
        User user = userRepository.findByEmail(email);
        if(Objects.equals(user.getPassword(), password)){
            return user;
        }
        return null;
    }

    @Transactional
    public User signUp(UserDTO user){
        User userCreate = new User(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getPhoto(), "USER");
        return userRepository.save(userCreate);
    }

    @Transactional
    public List<Order> getUserOrders(Long id){
        User user = userRepository.getReferenceById(id);
        return user.getOrders();
    }

    @Transactional
    public User getUserById(Long id){
        return userRepository.getReferenceById(id);
    }
}