package br.edu.catolica.seller_ms.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(String apiPath,
                            Integer httpStatus,
                            String message,
                            LocalDateTime errorTime) {
}
