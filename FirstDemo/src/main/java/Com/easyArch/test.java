package Com.easyArch;


import Com.easyArch.dao.UserDaoImp;

public class test {

    public static void main(String[] args) {

        UserDaoImp imp = new UserDaoImp();
        imp.showBoardMsg("2240170128");
        System.out.println(imp.showBoardMsg("2240170128"));

    }
}
