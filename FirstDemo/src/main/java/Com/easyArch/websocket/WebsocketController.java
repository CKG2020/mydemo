package Com.easyArch.websocket;

import Com.easyArch.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class WebsocketController {
    @Bean//这个注解会从Spring容器拿出Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

//    @RequestMapping("/websocket/login")
//    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String username = request.getParameter("username");
//        System.out.println(username+"登录");
//        System.out.println();
//        HttpSession session = request.getSession();
//        session.setAttribute("SESSION_USERNAME", username);
//        response.sendRedirect("test/chat.html");
//        return "test/chat";
//    }

    @RequestMapping("/websocket/send")
    @ResponseBody
    public String send(HttpServletRequest request) {
        String userSno = ((User)request.getSession().getAttribute("user")).getSno();
        infoHandler().sendMessageToUser(userSno, new TextMessage("你好，测试！！！！"));
        return null;
    }
}
