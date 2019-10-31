package Com.easyArch.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserBoard {
    private boolean IsFinishedQuestion ;
    private int Scores;
    private String Sno;
    private String Birth;
    private String Board;
    private String Cares;
    private List<String> friendList;
}
