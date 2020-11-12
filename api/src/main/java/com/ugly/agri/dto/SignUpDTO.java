package com.ugly.agri.dto;

import com.ugly.agri.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
public class SignUpDTO implements Serializable {
    @NotBlank
    String email;
    @NotBlank
    String password;
    @NotBlank
    String name;
    Boolean isSeller;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .isSeller(isSeller != null && isSeller)
                .build();
    }
}
