package shop.mtcoding.bank.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import shop.mtcoding.bank.dto.ResponseDTO;

public class CustomResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(CustomResponseUtil.class);

    public static void success(HttpServletResponse response, Object dto){
        try {
            ObjectMapper om = new ObjectMapper();
            ResponseDTO<?> responseDTO = new ResponseDTO<>(1,"로그인 성공", dto);
            String responseBody = om.writeValueAsString(responseDTO);
            response.setContentType("application/json; charset-utf-8");
            response.setStatus(200);
            response.getWriter().println(responseBody); // 예쁘게 메시지를 포장하는 공통적인 응답 패턴을 배워보자!!
        } catch (Exception e) {
            log.error("서버 파싱 에러");
        }
    }

    public static void fail(HttpServletResponse response, String msg, HttpStatus httpStatus){
        try {
            ObjectMapper om = new ObjectMapper();
            ResponseDTO<?> responseDTO = new ResponseDTO<>(-1, msg, null);
            String responseBody = om.writeValueAsString(responseDTO);
            response.setContentType("application/json; charset-utf-8");
            response.setStatus(httpStatus.value());
            response.getWriter().println(responseBody); // 예쁘게 메시지를 포장하는 공통적인 응답 패턴을 배워보자!!
        } catch (Exception e) {
            log.error("서버 파싱 에러");
        }
    }


}
