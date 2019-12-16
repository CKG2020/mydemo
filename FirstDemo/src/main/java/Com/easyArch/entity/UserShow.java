package Com.easyArch.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserShow implements Serializable {
    private String Sno;
    private String Sname;
    private int Sage;
    private String Scall;
    private String Sclass;
    private String Collage;
    private String Major;
    private int Scores;
}
