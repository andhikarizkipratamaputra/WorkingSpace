package com.example.demo.Service;

import com.example.demo.Model.account.User;
import com.example.demo.Web.Dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
