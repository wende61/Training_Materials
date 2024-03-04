package com.starter.springstarter.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiCustomeResponse {
    @Builder.Default
    private String statusCode = "-1";
    @Builder.Default
    private String statusMessage = "FAILED";
    private Object data;
}
