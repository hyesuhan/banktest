package shop.mtcoding.bank.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseDTO<T> {
    private final Integer code; // 1 success, -1 failed
    private final String msg;
    private final T data;
}
