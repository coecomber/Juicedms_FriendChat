package com.Herwaarden.FriendChat.Model;

import java.util.ArrayList;
import java.util.List;

public class MyFriendChats {
    List<MyFriendChat> friendChatList;

    public MyFriendChats() {
        this.friendChatList = new ArrayList<>();
    }

    public List<MyFriendChat> getFriendChatList() {
        return friendChatList;
    }
}
