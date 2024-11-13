package shop.mtcoding.bank.temp;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

// java.util.regex.Pattern
public class RegexTest {

    @Test
    public void 한글만된다_test() throws Exception {
        String value ="가나";
        boolean result = Pattern.matches("^[ㄱ-ㅎ가-힣]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만된다_test() throws Exception {
        String value ="abc";
        boolean result = Pattern.matches("^[a-zA-Z]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 한글은안된다_test() throws Exception {
        String value ="ab246";
        boolean result = Pattern.matches("^[^ㄱ-ㅎ가-힣]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만안된다_test() throws Exception {
        String value ="안녕 1234";
        boolean result = Pattern.matches("^[^a-zA-Z]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어와숫자만된다_test() throws Exception {
        String value ="abc1234";
        boolean result = Pattern.matches("^[a-zA-Z0-9]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만되고_길이는최소2_최대4이다_test() throws Exception {
        String value ="ab12";
        boolean result = Pattern.matches("^[a-zA-Z0-9]{2,4}$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void user_username_test() throws Exception {
        String username ="heasoo0202";
        boolean result = Pattern.matches("^[a-zA-Z0-9]{2,20}$", username);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void user_fullname_test() throws Exception {
        String fullname ="한혜수";
        boolean result = Pattern.matches("^[a-zA-Z가-힣]{1,20}$", fullname);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void user_email_test() throws Exception {
        String email = "heasoo@gmail.com";
        boolean result  = Pattern.matches("^[a-zA-Z0-9]{2,6}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}", email);
        System.out.println("테스트 : " + result);
    }

    // username; email; fullname
}
