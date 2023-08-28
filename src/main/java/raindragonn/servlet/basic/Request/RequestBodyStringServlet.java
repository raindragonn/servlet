package raindragonn.servlet.basic.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); //메시지 바디의 내용으 Byte 형식으로 가져옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // Spring에서 지원하는 유틸을 통해 스트링 변환
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
