package com.example.msl_b.serivce;

import com.example.msl_b.Domain.Entity.User;
import com.example.msl_b.Domain.Repository.UserRepository;
import com.example.msl_b.Domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User register(UserDto userDto) {
        User user = User.builder()
                .nickname(userDto.getNickname())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .build();
        return userRepository.save(user);
    }
    public User findUser(BigInteger id) {
        return userRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("User ID를 찾을 수 없습니다.");
        });
    }
}