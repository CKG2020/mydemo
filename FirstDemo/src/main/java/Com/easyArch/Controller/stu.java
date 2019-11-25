package Com.easyArch.Controller;


import Com.easyArch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@EnableRedisHttpSession
@RequestMapping("/stu")
@Controller
public class stu {

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "chat")
    public String ChatRoom(){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user.getSname());
        return "test/chat";
    }

    @RequestMapping(value = "Analyzing")
    public String Analyzing(){

        return "stu/Analyzing";
    }

    @RequestMapping(value = "Board")
    public String Board(){

        return "stu/Board";
    }
    @RequestMapping(value = "FriendList")
    public String FriendList(){

        return "stu/FriendList";
    }
    @RequestMapping(value = "MoreInfo")
    public String MoreInfo(){

        return "stu/MoreInfo";
    }

    @RequestMapping(value = "Questions")
    public String Questions(){

        return "stu/Questions";
    }


}
