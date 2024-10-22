package org.example.dto;

public record ResponseDto<T>(int code, T message) {
}
