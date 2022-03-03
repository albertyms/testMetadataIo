package com.metadata.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentRequest {

    @JsonProperty(value = "fullName")
    @NotNull(message = "fullName cannot be null")
    private String fullName;
    @JsonProperty(value = "numberId")
    @NotNull(message = "numberId cannot be null")
    private Long numberId;

}
