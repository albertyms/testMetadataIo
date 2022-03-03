package com.metadata.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseRequest {

    @JsonProperty(value = "nameCourse")
    @NotNull(message = "nameCourse cannot be null")
    private String nameCourse;
    @JsonProperty(value = "codeCourse")
    @NotNull(message = "codeCourse cannot be null")
    private String codeCourse;

}
