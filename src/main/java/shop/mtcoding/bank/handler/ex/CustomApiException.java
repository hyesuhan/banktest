package shop.mtcoding.bank.handler.ex;

import shop.mtcoding.bank.util.CustomResponseUtil;

public class CustomApiException extends RuntimeException{
    public CustomApiException(String message) {
        super(message);
    }
}
