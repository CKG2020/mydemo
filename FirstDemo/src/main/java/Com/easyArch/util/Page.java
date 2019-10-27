package Com.easyArch.util;

import Com.easyArch.entity.User;

import java.util.List;

public class Page {

    public static List<User> pageDiv(int currPage,int pageSize,List<User> list ){

        int firstIndex = (currPage - 1) * pageSize;
        int lastIndex = currPage * pageSize;
        try{
            return list.subList(firstIndex,lastIndex);

        }catch(Exception e){
            return list.subList(firstIndex,list.size());
        }

    }
}
