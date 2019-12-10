package Com.easyArch.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtil {
//    private static dateUtil util= new dateUtil();
//    private dateUtil(){
//
//    }

    public static String sendDate(){
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(now);
    }

}
