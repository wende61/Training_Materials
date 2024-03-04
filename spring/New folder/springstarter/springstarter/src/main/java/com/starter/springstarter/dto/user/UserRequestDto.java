package com.starter.springstarter.dto.user;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotEmpty
    private String name;
    @NotBlank
    private String email;
}
