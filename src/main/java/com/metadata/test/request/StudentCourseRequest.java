package com.metadata.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentCourseRequest {

    @JsonProperty(value = "idStudent")
    @NotNull(message = "idStudent cannot be null")
    private Long idStudent;
    @JsonProperty(value = "idCourse")
    @NotNull(message = "idCourse cannot be null")
    private Long idCourse;
}
