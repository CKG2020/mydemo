package Com.easyArch.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserBoard implements Serializable {
    private boolean IsFinishedQuestion ;
    private int Scores;
    private String Sno;
    private String Birth;
    private String Board;
    private String Cares;
    private List<String> friendList;
}
