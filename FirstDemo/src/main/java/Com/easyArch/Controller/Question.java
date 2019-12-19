package Com.easyArch.Controller;

import Com.easyArch.entity.ReturnAnswer;
import Com.easyArch.entity.User;
import Com.easyArch.service.QuestionService;
import Com.easyArch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@EnableRedisHttpSession
@RequestMapping("/stu/Questions")
@Controller
public class Question {

    @Autowired
    QuestionService questionService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;


    @RequestMapping("show")
    @ResponseBody
    public List showQuestions(@RequestParam int curr,int pageSize){
        System.out.println(curr+"\n"+pageSize);
//        questionService.showQuestion();
        return questionService.showQuestion(curr,pageSize);

    }

    @RequestMapping("sendAnswers")
    @ResponseBody
    public String Answers(@RequestBody List<ReturnAnswer> answersList) {
        String sno = ((User)request.getSession().getAttribute("user")).getSno();
        HttpSession session = request.getSession();
        session.setAttribute("userBoard",userService.addScores(sno,answersList));
        System.out.println(session.getAttribute("userBoard"));
        return "";
    }

    @RequestMapping("getResult")
    @ResponseBody
    public String getResult(@RequestParam String sno){

        return userService.returnResult(sno);
    }


    @RequestMapping("isFinished")
    @ResponseBody
    public String isFinished(@RequestParam String sno){
        System.out.println(sno);
        if(userService.isFinished(sno)){
            return "ok";
        }
        return "no";
    }
}
