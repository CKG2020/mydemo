package Com.easyArch.Controller;

import Com.easyArch.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@EnableRedisHttpSession
@RequestMapping("/stu/Questions")
@Controller
public class Question {

    @Autowired
    QuestionService questionService;

    @RequestMapping("show")
    @ResponseBody
    public List<Com.easyArch.entity.Question> showQuestions(@RequestParam int curr,int pageSize){
        System.out.println(curr+"\n"+pageSize);

        return questionService.showQuestion(curr,pageSize);

    }

    @RequestMapping("sendAnswers")
    @ResponseBody
    public String Answers(@RequestParam String questions){
//        System.out.println();
        System.out.println("xxx:"+ questions);

        return "";
    }
}
