package com.Herwaarden.FriendChat.Model;

import java.util.ArrayList;
import java.util.List;

public class FriendsChat {
    List<FriendChat> friendChatList;

    public FriendsChat(){
        this.friendChatList = new ArrayList<>();
    }

    public List<FriendChat> getFriendChatList(){
        return friendChatList;
    }

    public void addFriendChatList(FriendChat friendChat){
        friendChatList.add(friendChat);
    }

}
