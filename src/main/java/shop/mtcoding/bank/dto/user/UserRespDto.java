package shop.mtcoding.bank.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.util.CustomDateUtil;

public class UserRespDto {
    @ToString
    @Setter
    @Getter
    public static class JoinRespDto{


        @Getter
        @Setter
        public static class LoginResDto{
            private Long id;
            private String username;
            private String createdAt;

            public LoginResDto(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
                this.createdAt = CustomDateUtil.toStringFormat(user.getCreatedAt());
            }
        }


        private Long id;
        private String username;
        private String fullname;

        public JoinRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.fullname = user.getFullname();
        }
    }
}
