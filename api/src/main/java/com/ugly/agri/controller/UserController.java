package com.ugly.agri.controller;

import com.ugly.agri.common.Response;
import com.ugly.agri.dto.SignInDTO;
import com.ugly.agri.dto.SignUpDTO;
import com.ugly.agri.dto.UserDTO;
import com.ugly.agri.dto.UserInfoDTO;
import com.ugly.agri.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = {"2. User"})
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "전체 유저 조회")
    @GetMapping("/users")
    public Response<List<UserDTO>> getUsers() {
        return Response.ok(userService.getUsers());
    }

    @ApiOperation(value = "유저 조회")
    @GetMapping("/users/{id}")
    public Response<UserDTO> getUser(@PathVariable Long id) {
        return Response.ok(userService.getUser(id));
    }

    @ApiOperation(value = "유저 생성. 회원가입")
    @PostMapping("/users")
    public Response<UserDTO> createUser(@RequestBody @Valid SignUpDTO signUpDTO) {
        return Response.ok(userService.createUser(signUpDTO));
    }

    @ApiOperation(value = "유저 수정")
    @PutMapping("/users/{id}")
    public Response<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserInfoDTO userInfoDTO) {
        return Response.ok(userService.updateUser(id, userInfoDTO));
    }

    @ApiOperation(value = "유저 삭제")
    @DeleteMapping("/users/{id}")
    public Response<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return Response.ok();
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public Response<UserDTO> loginUser(@RequestBody @Valid SignInDTO signInDTO) {
        return Response.ok(userService.loginUser(signInDTO));
    }
}
