package com.springboot.board.service;

import com.springboot.board.domain.dto.UserJoinReq;
import com.springboot.board.domain.dto.UserJoinRes;
import com.springboot.board.domain.entity.User;
import com.springboot.board.exception.ErrorCode;
import com.springboot.board.exception.SpringBootAppException;
import com.springboot.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserJoinRes join(UserJoinReq request) {
        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> {
                    throw new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%s는 이미 존재하는 회원입니다.", request.getUserName()));
                });

        User user = userRepository.save(request.toEntity(encoder.encode(request.getPassword())));
        return UserJoinRes.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

}
