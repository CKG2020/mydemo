package Com.easyArch.entity;


import lombok.Data;

@Data
public class Answer {

    private int AnswerID;//答案号
    private String context;
    private int score;
    private boolean isChoose =  false;
}
