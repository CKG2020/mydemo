package Com.easyArch.Controller;


import Com.easyArch.entity.FormValidate;
import Com.easyArch.entity.BoardMsg;
import Com.easyArch.entity.User;
import Com.easyArch.service.FriendsService;
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
    @Autowired
    FriendsService friendsService;

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
    @RequestMapping(value="FriendList/getRequest")
    @ResponseBody
    public  List<User>  getRequest(){
        HttpSession session = request.getSession();
        return userService.showFriendsRequest(((User)session.getAttribute("user")).getSno());
    }
    @RequestMapping(value="FriendList/friendInfo")
    @ResponseBody
    public User getFriendInfo(@RequestParam String sno){
        return userService.findUserBySno(sno);
    }

    @RequestMapping(value="FriendList/showFewBoardMsg")
    @ResponseBody
    public List getFewBoardMsg(@RequestParam String sno){
        return userService.showBoardMsg(sno);
    }

    @RequestMapping(value="FriendList/addNewBoardMsg")
    @ResponseBody
    public String addNewBoardMsg(@RequestBody BoardMsg msg){
        HttpSession session = request.getSession();
        msg.setFrom_name(((User)session.getAttribute("user")).getSname());
        userService.addBoardMsg(msg);
        return "";
    }

    @RequestMapping(value="findBySno")
    @ResponseBody
    public List<User> findBySno(@RequestParam String Sno){
        System.out.println("Sno"+Sno);
        return userService.findUsersBySno(Sno);
    }
    @RequestMapping(value="friendsCount")
    @ResponseBody
    public int friendsCount(){
        HttpSession session = request.getSession();
        return userService.findFriendsCount(((User)session.getAttribute("user")).getSno());
    }

    @RequestMapping(value="findSnoCount")
    @ResponseBody
    public int findSnoCount(@RequestParam String Sno){
        return userService.findSnoCount(Sno);
    }

    @RequestMapping(value="findByName")
    @ResponseBody
    public List<User> findbyName(@RequestParam String Sname){
        return userService.findUsersByName(Sname);
    }

    @RequestMapping(value="findNameCount")
    @ResponseBody
    public int findNameCount(@RequestParam String Sname){
        return userService.findNameCount(Sname);
    }

    @RequestMapping(value="addRequest")
    @ResponseBody
    public String addRequest(@RequestParam String sno){
        HttpSession session = request.getSession();
        userService.addRequest(((User)session.getAttribute("user")).getSno(),sno);
        return "";
    }

    @RequestMapping(value="acceptRequest")
    @ResponseBody
    public String acceptRequest(@RequestParam String sno){
        HttpSession session = request.getSession();
        userService.acceptRequest(sno,((User)session.getAttribute("user")).getSno());
        return "";
    }

    @RequestMapping(value="countRequest")
    @ResponseBody
    public int countRequest(){
        HttpSession session = request.getSession();
        return userService.countRequest(((User)session.getAttribute("user")).getSno());
    }


}
