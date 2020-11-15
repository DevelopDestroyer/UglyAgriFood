package com.ugly.agri.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
public class SignInDTO implements Serializable {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
