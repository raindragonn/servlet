package raindragonn.servlet.web.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import raindragonn.servlet.web.frontcontroller.ModelView;

import java.io.IOException;

public interface MyHandlerAdapter {

    // 지원 가능 여부를 확인한다.
    boolean supports(Object handler);

    // 핸들러(Controller) 처리
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
