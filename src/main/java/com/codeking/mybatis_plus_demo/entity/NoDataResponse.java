package com.codeking.mybatis_plus_demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoDataResponse {

    @JsonProperty("error_code")
    private Integer errorCode = 0;

    @JsonProperty("error_message")
    private String errorMessage = "success";

    public NoDataResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
