package raindragonn.servlet.basic.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;


/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(name -> System.out.println(name + ": "+ request.getParameter(name)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username"); //단일 파라미터 조회
        String age = request.getParameter("age"); //단일 파라미터 조회
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");

        System.out.println("[복수 파라미터 조회] - start");
        String[] usernames = request.getParameterValues("username"); //복수 파라미터 조회
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        System.out.println("[복수 파라미터 조회] - end");


        Enumeration<String> parameterNames = request.getParameterNames(); //파라미터 이름들 모두 조회
        Map<String, String[]> parameterMap = request.getParameterMap(); //파라미터를 Map 으로 조회
        response.getWriter().write("ok");

    }
}
