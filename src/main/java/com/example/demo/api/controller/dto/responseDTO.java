package com.example.demo.api.controller.dto;

import com.example.demo.api.persistence.entity.userEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class responseDTO {


    @JsonProperty("before")
    userEntity userBefore;
    @JsonProperty("after")
    userEntity userAfter;


}
