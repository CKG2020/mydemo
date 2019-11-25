package Com.easyArch.util;

import Com.easyArch.entity.Answer;
import Com.easyArch.entity.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadTxt {

    public static List<Question> ReadQuestions(String url){

        File f  = new File(url);
        List<Question> questions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
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



}
