package shop.mtcoding.bank.config.jwt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.mtcoding.bank.config.auth.LoginUser;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserEnum;

public class JwtProcessTest {

    @Test
    public void test() throws Exception {
        // given
        User user = User.builder().id(1L).role(UserEnum.CUSTOMER).build();
        LoginUser loginUser = new LoginUser(user);

        // when
        String jwtToken = JwtProcess.create(loginUser);
        System.out.println("테스트 : " + jwtToken);

        // then
        Assertions.assertTrue(jwtToken.startsWith(JwtVO.TOKEN_PREFIX));

    }

    @Test
    public void verify_test() throws Exception {
        // given
        String jwtToken = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJiYW5rIiwiZXhwIjoxNzMyNjAyMTU4LCJpZCI6MSwicm9sZSI6IkNVU1RPTUVSIn0.A1L6V0zpav36YNc13-5EwWsVmlB0ZC7f01jMqAgiry9K-K5bZXb1uYie8BC7jEhKfCTaZpmiwqjpwQtI-vdiNQ";


        // when
        LoginUser loginUser = JwtProcess.verify(jwtToken);
        System.out.println("테스트 : " + loginUser.getUser().getId());

        // then
        org.assertj.core.api.Assertions.assertThat(loginUser.getUser().getId()).isEqualTo(1L);

    }
}
