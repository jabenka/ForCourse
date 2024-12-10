package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketDto {

    @JsonProperty("id")
    Long id;

    @JsonProperty("title")
    String title;

    @JsonProperty("event")
    String event;

    @JsonProperty("user_id")
    UserDto user;
}
