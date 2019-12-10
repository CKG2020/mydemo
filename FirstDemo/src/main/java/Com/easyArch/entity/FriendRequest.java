package Com.easyArch.entity;


import lombok.Data;

@Data
public class FriendRequest {
    private String sno1;
    private String sno2;
    private boolean addStatus;
    //1:已通过
    //0:待处理
}
