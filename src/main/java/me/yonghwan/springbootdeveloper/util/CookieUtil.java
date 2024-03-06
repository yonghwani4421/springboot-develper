package me.yonghwan.springbootdeveloper.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.SerializationUtils;

import java.util.Base64;


public class CookieUtil {

    /**
     *
     @작성자 : admin
     @작성일 : 2024 02 26 오후 4:35
     @변경이력 :  요청 (이름, 값, 만료 기간)을 바탕으로 쿠키 추가
      * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     *
     @작성자 : admin
     @작성일 : 2024 02 26 오후 4:39
     @변경이력 :  Cookie 입력 받아 쿠키 삭제
      * @param response
     * @param name
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name){
        Cookie[] cookies = request.getCookies();

        if(cookies == null){
            return;
        }

        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                cookie.setPath("/");
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    /**
     *
     @작성자 : admin
     @작성일 : 2024 02 26 오후 4:41
     @변경이력 :  객체를 직렬화해 쿠키의 값으로 변환
      * @return
     */
    public static String serialize(Object obj){
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(obj));
    }

    /**
     *
     @작성자 : admin
     @작성일 : 2024 02 26 오후 4:44
     @변경이력 :  쿠키를 역직렬화해 객체로 변환
      * @param cls
     * @return
     * @param <T>
     */
    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(
                SerializationUtils.deserialize(
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }

}
