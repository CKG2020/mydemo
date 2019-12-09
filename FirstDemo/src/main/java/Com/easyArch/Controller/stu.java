package Com.easyArch.Controller;


import Com.easyArch.entity.FormValidate;
import Com.easyArch.entity.BoardMsg;
import Com.easyArch.entity.User;
import Com.easyArch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@EnableRedisHttpSession
@RequestMapping("/stu")
@Controller
public class stu {

    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;

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
    @RequestMapping(value = "update")
    @ResponseBody
    public String updateInfo(@RequestBody FormValidate formValidate){
        userService.updateUser(formValidate);
        System.out.println(formValidate.toString());
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.setAttribute("user",userService.findUserBySno(formValidate.getSno()));
        return "ok";
    }

    @RequestMapping(value = "Questions")
    public String Questions(){
        return "stu/Questions";
    }

    @RequestMapping(value = "Board/getBoard")
    @ResponseBody
    public List<BoardMsg> getBoard(){
        HttpSession session = request.getSession();
        return userService.showBoardMsg(((User)session.getAttribute("user")).getSno());
    }


    @RequestMapping(value="FriendList/showFriends")
    @ResponseBody
    public List<User> getFriends(){
        HttpSession session = request.getSession();
        return userService.showFriends(((User)session.getAttribute("user")).getSno());
    }

}
