package com.Herwaarden.FriendChat.Factory;

import com.Herwaarden.FriendChat.DAL.Context.FriendChatContextSQL;
import com.Herwaarden.FriendChat.DAL.Interface.Repository.IFriendChatRepository;
import com.Herwaarden.FriendChat.DAL.Repository.FriendChatRepository;

public class FriendChatFactory {
    private FriendChatRepository friendChatRepository;

    public IFriendChatRepository getFriendChatSQLRepository(){
        friendChatRepository = new FriendChatRepository(new FriendChatContextSQL());
        return friendChatRepository;
    }
}
