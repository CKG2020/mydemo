package Com.easyArch.Controller;

import Com.easyArch.entity.User;
import Com.easyArch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@EnableRedisHttpSession
@RequestMapping("/")
@Controller

public class First {

    @Autowired
    UserService userService ;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("Login")
    public String test(){
        return "First/Login";
    }

    @RequestMapping("LoginAdmin")
    public String test2(){ return "First/LoginAdmin"; }

    @RequestMapping(value = "ok" ,method = RequestMethod.POST)
    @ResponseBody
    public Object ok(@RequestParam String Sno, String Spwd){
        User user;
        Object obj = userService.login(Sno,Spwd);
        if (obj.equals(1)||obj.equals(0)){
            return obj.toString();
        }
        HttpSession session = request.getSession();
        user=(User)obj;
        session.setAttribute("user",user);
        return user;
    }//用户登录

    @RequestMapping("stu")//登录成功跳转页面
    public String suc(){
        if(request.getSession().getAttribute("user")==null){
            return "First/Login";
        }else{
            return "stu/MoreInfo";
        }
    }

    //跳转后再把user查出来
    @RequestMapping("search")
    @ResponseBody
    public Object search(){
        HttpSession session = request.getSession();
        return session.getAttribute("user");
    }

    @RequestMapping("Register")//用户注册
    public String register(){
        return "First/Register";
    }


    @RequestMapping("/admin")
    @ResponseBody//管理员
    public String admin(@RequestParam String Sno, String Spwd){
        System.out.println(userService.adminLogin(Sno,Spwd));
        if(userService.adminLogin(Sno,Spwd)!=null){
            return "ok";
        }
        return null;
    }
    @RequestMapping("findall")//登录成功跳转页面
    public String all(){
        return "admin/demo";
    }

    @RequestMapping("isused")
    @ResponseBody
    public String used(@RequestParam String Sno){
        System.out.println(Sno);
        Object obj = userService.findUserBySno(Sno);
        if(obj!=null){
            return "此用户已存在!";
        }else{
            return "ok";
        }

    }

    @RequestMapping(value = "addUser" ,method = RequestMethod.POST)
    public String submit(@RequestParam String Sno, String Spwd){
        User user=userService.addUser(Sno,Spwd);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        System.out.println("user"+user);
        return "stu/MoreInfo";
    }

    @RequestMapping("logout")
    public String logout(){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        request.getSession().invalidate();
        return "First/Login";
    }






}
