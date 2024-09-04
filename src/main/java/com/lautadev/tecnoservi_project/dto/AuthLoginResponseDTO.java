package com.lautadev.tecnoservi_project.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","message","JWT","status"})
public record AuthLoginResponseDTO(String username,
                                   String message,
                                   String JWT,
                                   boolean status) {
}