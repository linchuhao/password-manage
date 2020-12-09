package com.example.demo.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank
    private String username;
    @NotBlank
    @Valid
    private String oldPassword;
    @NotBlank
    @Valid
    private String newPassword;
}
