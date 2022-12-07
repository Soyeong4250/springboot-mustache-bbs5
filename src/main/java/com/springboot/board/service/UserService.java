package com.springboot.board.service;

import com.springboot.board.domain.dto.UserJoinReq;
import com.springboot.board.domain.dto.UserJoinRes;
import com.springboot.board.domain.entity.User;
import com.springboot.board.exception.ErrorCode;
import com.springboot.board.exception.SpringBootAppException;
import com.springboot.board.repository.UserRepository;
import com.springboot.board.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    @Value("${jwt.token.secret}")
    private String secretKey;
    private long expireTimeMs = 1000L * 60 * 60;

    public UserJoinRes join(UserJoinReq request) {
        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> {
                    throw new SpringBootAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s는 이미 존재하는 회원입니다.", request.getUserName()));
                });

        User user = userRepository.save(request.toEntity(encoder.encode(request.getPassword())));
        return UserJoinRes.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public String login(String userName, String password) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%s는 존재하지 않는 회원입니다.", userName)));

        if(!encoder.matches(password, user.getPassword())) {
            throw new SpringBootAppException(ErrorCode.INVALID_PASSWORD, "userName 또는 password를 확인해주세요.");
        }

        return JwtTokenUtil.createToken(userName, secretKey, expireTimeMs);
    }
}
