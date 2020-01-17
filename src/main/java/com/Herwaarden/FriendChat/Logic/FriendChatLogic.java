package com.Herwaarden.FriendChat.Logic;

import com.Herwaarden.FriendChat.DAL.Interface.Repository.IFriendChatRepository;
import com.Herwaarden.FriendChat.Factory.FriendChatFactory;
import com.Herwaarden.FriendChat.Model.FriendChat;
import com.Herwaarden.FriendChat.Model.MyFriendChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class FriendChatLogic {
    private IFriendChatRepository friendChatRepository;

    @Autowired
    private RestTemplate restTemplate;

    public FriendChatLogic(){
        friendChatRepository = new FriendChatFactory().getFriendChatSQLRepository();
    }

    public List<MyFriendChat> getChatsByUserId(int userId){
        List<MyFriendChat> myFriendChats = new ArrayList<>();

        for(FriendChat friendChat : friendChatRepository.getAllChats().getFriendChatList()){
            if (userId == friendChat.getReceiverId() || userId == friendChat.getSenderId()) {
                MyFriendChat myFriendChat = new MyFriendChat();

                //If I'm the receiver (then add sender)
                if(friendChat.getReceiverId() == userId){
                    myFriendChat.setFriendId(friendChat.getSenderId());
                    myFriendChat.setFriendIsSender(true);
                }
                //If I'm the sender (then add receiver)
                else{
                    myFriendChat.setFriendId(friendChat.getReceiverId());
                    myFriendChat.setFriendIsSender(false);
                }
                myFriendChat.setMessage(friendChat.getMessage());
                myFriendChats.add(myFriendChat);
            }
        }

        return myFriendChats;
    }
}
