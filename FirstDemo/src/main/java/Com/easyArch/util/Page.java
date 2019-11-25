package Com.easyArch.util;

import Com.easyArch.entity.Question;
//import Com.easyArch.entity.User;

import java.util.List;

public class Page {


    public static List pageDiv(int currPage,int pageSize,List list ){

        int firstIndex = (currPage - 1) * pageSize;
        int lastIndex = currPage * pageSize;
        try{
            return list.subList(firstIndex,lastIndex);

        }catch(Exception e){
            return list.subList(firstIndex,list.size());
        }
    }

//    public static List<Question> QuestionDiv(){
//        return null;
//    }
}
