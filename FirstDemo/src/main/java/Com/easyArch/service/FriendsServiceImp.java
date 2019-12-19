package Com.easyArch.service;

import Com.easyArch.dao.FriendsDao;
import Com.easyArch.dao.FriendsDaoImp;
import Com.easyArch.entity.BoardMsg;
import Com.easyArch.util.dateUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServiceImp implements FriendsService {

    FriendsDao friendsDao = new FriendsDaoImp();

    @Override
    public int countFriends(String sno) {
        return 0;
    }

    @Override
    public boolean addFriend(String sno1, String sno2) {
        return false;
    }

    @Override
    public String tipsMessage() {
        return null;
    }

    @Override
    public String friendhandler() {
        return null;
    }

    @Override
    public List<String> showAdd() {
        return null;
    }

    @Override
    public boolean addBoardMsg(BoardMsg msg) {
        msg.setDate_time(dateUtil.sendDate());
        return friendsDao.insertBoardMsg(msg);
    }
}
