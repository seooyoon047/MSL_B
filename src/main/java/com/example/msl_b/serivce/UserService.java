package com.example.msl_b.serivce;


import com.example.msl_b.Domain.Entity.User;
import com.example.msl_b.Domain.Repository.UserRepository;
import com.example.msl_b.Domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(UserDto registerDto) {
        User user = new User();
        user.setName(registerDto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
        user.setUsername(registerDto.getUsername());
        user.setRoles("ROLE_USER");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(BigInteger id) {
        return userRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("User ID를 찾을 수 없습니다.");
        });
    }
}
