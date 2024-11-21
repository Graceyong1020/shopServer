package org.pgm.shopserver.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

@Log4j2
public class SecurityUtils {
    public static final String ROLE_PREFIX = "ROLE_"; // ROLE_이라는 prefix를 붙여서 권한을 부여
    public static final String AUTH_HEADER = "authorization"; // 헤더에 Authorization이라는 이름으로 토큰을 담아서 보냄
    public static final String AUTH_TOKEN_TYPE = "Bearer"; // 토큰 타입을 Bearer로 지정
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " "; // Bearer 다음에 공백을 넣어서 토큰을 구분


    public static SimpleGrantedAuthority convertToAuthority(String role) {
        String formatRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formatRole);

    }
    public static String extractAuthTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(AUTH_HEADER);

        if(StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX)){
            log.info(bearerToken.substring(7));
            return bearerToken.substring(7); // Bearer 다음에 공백을 넣어서 토큰을 구분
        }
        return null;
    }
}
