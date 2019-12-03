package Com.easyArch.util;

import Com.easyArch.entity.Answer;
import Com.easyArch.entity.Question;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadTxt {

    public static List<Question> ReadQuestions(String url){
//        File f  = new File(url);
        List<Question> questions = new ArrayList<>();
        try {
            ClassPathResource classPathResource = new ClassPathResource(url);
            InputStream in = classPathResource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String title;
            String str;
            int id=0;
            int answerId=0;
            while ((str=br.readLine())!=null){
                if(!str.contains("//")){
                    title=str;
                    Question q = new Question();
                    q.setTitle(title);
                    id=id+1;
                    answerId=0;
                    q.setQuestionID(id);
                    q.setAnswers(new ArrayList<>());
                    questions.add(q);
                }else if (str.contains("//")) {
                    Answer a = new Answer();
                    answerId++;
                    a.setAnswerID(answerId);
                    a.setContext(str.split("//")[0]);
                    a.setScore(Integer.parseInt(str.split("//")[1]));
                    Question q = questions.get(questions.size()-1);
                    List<Answer> list = q.getAnswers();
                    list.add(a);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static String sendResult(String scores) {
//        File f = null;
        String res = "";
//        ClassPathResource resource = new ClassPathResource();
        try {

//            f = ResourceUtils.getFile("classpath:Questions/Research_2_Res");
//        File f  = new File("classpath:Questions/Research_2_Res");
            ClassPathResource classPathResource = new ClassPathResource("classpath:Questions/Research_2_Res");
            InputStream in = classPathResource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

//            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            while ((str=br.readLine())!=null){
                if(str.equals(scores)){
                    res=br.readLine();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
