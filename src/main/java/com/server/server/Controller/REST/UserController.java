package com.server.server.Controller.REST;


import com.server.server.Controller.DTO.OrderDTO;
import com.server.server.Controller.DTO.SignInDTO;
import com.server.server.Controller.DTO.UserDTO;
import com.server.server.Model.User;
import com.server.server.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public UserDTO signIn(@RequestBody SignInDTO signInDTO){
        return new UserDTO(userService.signIn(signInDTO.getEmail(), signInDTO.getPassword()));
    }

    @PostMapping("/signup")
    public UserDTO signUp(@RequestBody UserDTO userDTO){
        User user = userService.signUp(userDTO);
        return new UserDTO(user);
    }

    @GetMapping("/getorders/{id}")
    public List<OrderDTO> getUserOrders(@PathVariable("id") Long id){
        return userService.getUserOrders(id).stream()
                .map(OrderDTO::new)
                .toList();
    }
}