package Com.easyArch.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private String username;
    private String password;
}
