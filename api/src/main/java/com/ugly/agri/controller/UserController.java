package com.ugly.agri.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ugly.agri.common.Response;
import com.ugly.agri.dto.SignUpDTO;
import com.ugly.agri.dto.UserDTO;
import com.ugly.agri.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(tags = {"2. User"})
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "전체 유저 조회")
    @GetMapping
    public Response<List<UserDTO>> getUsers() {
        return Response.ok(userService.getUsers());
    }

    @ApiOperation(value = "유저 조회")
    @GetMapping("/{id}")
    public Response<UserDTO> getUser(@PathVariable Long id) {
        return Response.ok(userService.getUser(id));
    }

    @ApiOperation(value = "유저 생성")
    @PostMapping
    public Response<String> createUser(@RequestBody @Valid SignUpDTO signUpDTO) {
        userService.createUser(signUpDTO);
        return Response.ok();
    }

    @ApiOperation(value = "유저 수정")
    @PutMapping("/{id}")
    public Response<String> updateUser(@PathVariable Long id, @RequestParam("isSeller") Boolean isSeller) {
        userService.updateUser(id, isSeller);
        return Response.ok();
    }

    @ApiOperation(value = "유저 삭제")
    @DeleteMapping("/{id}")
    public Response<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return Response.ok();
    }
}
