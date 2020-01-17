package com.Herwaarden.FriendChat.DAL.Repository;

import com.Herwaarden.FriendChat.DAL.Interface.Context.IFriendChatContext;
import com.Herwaarden.FriendChat.DAL.Interface.Repository.IFriendChatRepository;
import com.Herwaarden.FriendChat.Model.FriendsChat;

public class FriendChatRepository  implements IFriendChatRepository {

    private IFriendChatContext friendChatContext;

    public FriendChatRepository(IFriendChatContext context) {
        friendChatContext = context;
    }

    @Override
    public FriendsChat getAllChats() {
        return friendChatContext.getAllChats();
    }

    @Override
    public boolean addMessage(int senderId, int receiverId, String message) {
        return friendChatContext.addMessage(senderId, receiverId, message);
    }
}
