package com.ugly.agri.dto;

import com.ugly.agri.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
public class SignUpDTO implements Serializable {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    private Boolean isSeller;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .isSeller(isSeller != null && isSeller)
                .build();
    }
}
