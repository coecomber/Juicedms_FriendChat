package com.Herwaarden.FriendChat.DAL.Interface.Context;

import com.Herwaarden.FriendChat.Model.FriendsChat;

public interface IFriendChatContext {
    FriendsChat getAllChats();
    boolean addMessage(int senderId, int receiverId, String message);
}
