package Com.easyArch;


import Com.easyArch.dao.FriendsDaoImp;
import Com.easyArch.dao.UserDaoImp;
import Com.easyArch.entity.BoardMsg;

public class test {

    public static void main(String[] args) {

        UserDaoImp imp = new UserDaoImp();
        System.out.println(imp.findUsersBySno("224017"));
//        imp.showBoardMsg("2240170128");
//        System.out.println(imp.showBoardMsg("2240170128"));
//
//        FriendsDaoImp imp2 = new FriendsDaoImp();
//        BoardMsg msg = new BoardMsg();
//        msg.setBoard_text("tesst222222222222222");
//        msg.setDate_time("2019-12-01 11:11:11");
//        msg.setFrom_name("me");
//        msg.setSno("2240170128");
//        imp2.insertBoardMsg(msg);
//
//        System.out.println(imp.showBoardMsg("2240170128"));


    }
}
