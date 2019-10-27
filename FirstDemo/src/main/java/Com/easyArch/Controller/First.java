package Com.easyArch.Controller;

import Com.easyArch.entity.User;
import Com.easyArch.service.UserService;
import Com.easyArch.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/")
@Controller
public class First {

    @Autowired
    UserService userService ;
    User user ;

    @RequestMapping("Login")
    public String test(){
        return "First/Login";
    }

    @RequestMapping("LoginAdmin")
    public String test2(){ return "First/LoginAdmin"; }

    @RequestMapping(value = "ok" ,method = RequestMethod.POST)
    @ResponseBody
    public Object ok(@RequestParam String Sno, String Spwd){
        Object obj = userService.login(Sno,Spwd);
        if (obj.equals(1)||obj.equals(0)){
            return obj.toString();
        }
        user=(User)obj;
        return user;
    }//用户登录

    @RequestMapping("suc")//登录成功跳转页面
    public String suc(){
        return "success";
    }

    //跳转后再把user查出来
    @RequestMapping("search")
    @ResponseBody
    public User search(){
        System.out.println(user);
        return user;
    }

    @RequestMapping("Register")//用户注册
    public String register(){
        return "First/Register";
    }


    @RequestMapping("/admin")
    @ResponseBody//管理员
    public String admin(@RequestParam String Sno, String Spwd){
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
    public Object used(@RequestParam String Sno){
        Object obj = userService.findUserBySno(Sno);
        if(obj!=null){
            return "此用户已存在!";
        }else{
            return "ok";
        }

    }

    @RequestMapping(value = "addUser" ,method = RequestMethod.POST)
    public String submit(@RequestParam String Sno, String Spwd){
        user=userService.addUser(Sno,Spwd);
        System.out.println("user"+user);
        return "stu/MoreInfo";
    }




}
