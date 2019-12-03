package Com.easyArch.Controller;

import Com.easyArch.entity.ReturnAnswer;
import Com.easyArch.entity.User;
import Com.easyArch.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@EnableRedisHttpSession
@RequestMapping("/stu/Questions")
@Controller
public class Question {

    @Autowired
    QuestionService questionService;
    @Autowired
    HttpServletRequest request;

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
        questionService.addScores(((User)request.getSession().getAttribute("user")).getSno(),answersList);
//        System.out.println("xxx:"+ sc);
//        System.out.println(questionService.RetrunResult(sc));
        return "";
    }

    @RequestMapping("getResult")
    @ResponseBody
    public String getResult(@RequestParam String sno){
        return questionService.returnResult(sno);
    }


    @RequestMapping("isFinished")
    @ResponseBody
    public String isFinished(@RequestParam String sno){
        System.out.println(sno);
        if(questionService.isFinished(sno)){
            return "ok";
        }
        return "no";
    }
}
