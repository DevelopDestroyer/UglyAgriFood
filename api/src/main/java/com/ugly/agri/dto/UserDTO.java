package com.ugly.agri.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
    Long id;
    String email;
    String name;
    Boolean isSeller;
}
