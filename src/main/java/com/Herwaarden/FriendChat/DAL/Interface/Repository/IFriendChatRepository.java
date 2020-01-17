package com.Herwaarden.FriendChat.DAL.Interface.Repository;

import com.Herwaarden.FriendChat.Model.FriendsChat;

public interface IFriendChatRepository {
    FriendsChat getAllChats();
    boolean addMessage(int senderId, int receiverId, String message);
}
