package shop.mtcoding.bank.config.jwt;

/*
* SECRET 노출되면 안 된다. (환경변수, 클라우드 AWS, 파일에 있는 것을 읽을 수도 있고)
* REFRESH TOKEN ( 현재 구현 x )
 */
public interface JwtVO {
    public static final String SECRET = "메타코딩"; // HS256 ( 대칭키 )
    public static final int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7;  // 일주일
    public static final String TOKEN_PREFIX = "Bearrer";
    public static final String HEADER = "Authorization";
}
