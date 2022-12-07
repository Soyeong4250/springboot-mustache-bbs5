package com.springboot.board.controller;

import com.springboot.board.domain.dto.UserJoinReq;
import com.springboot.board.domain.dto.UserJoinRes;
import com.springboot.board.domain.dto.UserLoginReq;
import com.springboot.board.domain.dto.UserLoginRes;
import com.springboot.board.domain.entity.Response;
import com.springboot.board.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinRes> join(@RequestBody UserJoinReq userJoinReq) {
        UserJoinRes user = userService.join(userJoinReq);
        return Response.success(new UserJoinRes(user.getUserName(), user.getEmail(), user.getRole()));
    }

    @PostMapping("/login")
    public Response<UserLoginRes> login(@RequestBody UserLoginReq userLoginReq) {
        String token = userService.login(userLoginReq.getUserName(), userLoginReq.getPassword());
        return Response.success(new UserLoginRes(token));
    }
}
