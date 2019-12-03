package Com.easyArch.Controller;


import Com.easyArch.entity.AnalyzingData;
import Com.easyArch.entity.User;
import Com.easyArch.service.UserService;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class admin {

    @Autowired
    UserService userService;

    @RequestMapping("findallcount")
    @ResponseBody
    public int findallcount(){
        userService.findAll();
        return userService.findallcount();
    }

    @RequestMapping("findpage")
    @ResponseBody
    public List<User> findpage(@RequestParam String curr, String pageSize){
        return userService.findpage(Integer.valueOf(curr),Integer.valueOf(pageSize));
    }

    @RequestMapping("findbySno")
    @ResponseBody
    public List<User> findbySno(@RequestParam String Sno){
        return userService.findUsersBySno(Sno);
    }

    @RequestMapping("findbyAge")
    @ResponseBody
    public List<User> findbyAge(@RequestParam String Sage){
        return userService.findUsersByAge(Integer.valueOf(Sage));
    }
    @RequestMapping("findbyCollage")
    @ResponseBody
    public List<User> findbyCollage(@RequestParam String Collage){
        return userService.findUsersByCollage(Collage);
    }
    @RequestMapping("findbyClass")
    @ResponseBody
    public List<User> findbyClass(@RequestParam String Sclass){
        return userService.findUsersByClass(Sclass);
    }

    @RequestMapping("findbyName")
    @ResponseBody
    public List<User> findbyName(@RequestParam String Sname){
        return userService.findUsersByName(Sname);
    }

    @RequestMapping("findAgeCount")
    @ResponseBody
    public int findAgeCount(@RequestParam String age){
        return userService.findAgeCount(Integer.valueOf(age));
    }

    @RequestMapping("findNameCount")
    @ResponseBody
    public int findNameCount(@RequestParam String Sname){
        return userService.findNameCount(Sname);
    }

    @RequestMapping("findCollageCount")
    @ResponseBody
    public int findCollageCount(@RequestParam String Collage){
        return userService.findCollageCount(Collage);
    }

    @RequestMapping("findClassCount")
    @ResponseBody
    public int findClassCount(@RequestParam String Sclass){
        return userService.findClassCount(Sclass);
    }

    @RequestMapping("findSnoCount")
    @ResponseBody
    public int findSnoCount(@RequestParam String Sno){
        return userService.findSnoCount(Sno);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam String Sno){
        if(userService.delUser(Sno))
            return "ok";
        else{
            return "wrong!";
        }
    }
    @RequestMapping("deleteuser")
    public String deleteuser(){
        return "admin/demodel";
    }
    @RequestMapping("analyzing")
    public String analyzing(){
        return "admin/analyzing";
    }
    @RequestMapping("listener")
    public String listener(){
        return "admin/listener";
    }
    @RequestMapping("addQuestion")
    public String addQuestion(){
        return "admin/addQuestion";
    }


    @RequestMapping(value="finishedPercent")
    @ResponseBody
    public AnalyzingData finishedPercent(){
        System.out.println(userService.analyzingRes());
        return userService.analyzingRes();

    }





}
