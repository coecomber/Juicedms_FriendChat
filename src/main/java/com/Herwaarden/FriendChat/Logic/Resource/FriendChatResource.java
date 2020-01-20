package com.Herwaarden.FriendChat.Logic.Resource;

import com.Herwaarden.FriendChat.Logic.FriendChatLogic;
import com.Herwaarden.FriendChat.Model.FriendChat;
import com.Herwaarden.FriendChat.Model.MyFriendChat;
import com.Herwaarden.FriendChat.Model.MyFriendChats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FriendChatResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("chats/{userId}")
    public MyFriendChats getMyFriendChat(@PathVariable("userId") int userId){
        FriendChatLogic friendChatLogic = new FriendChatLogic();

        MyFriendChats myFriendChats = new MyFriendChats();

        for(MyFriendChat myFriendChat : friendChatLogic.getChatsByUserId(userId)){
            myFriendChats.getFriendChatList().add(myFriendChat);
        }

        return myFriendChats;
    }

    //Example body JSON: "{"senderId": "1", "receiverId": "2", "message": "hi there!"}"
    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @PostMapping("chat/get/")
    public void postTest(@RequestBody FriendChat friendChat){
        System.out.println(friendChat.getMessage());
        System.out.println(friendChat.getReceiverId());
        System.out.println(friendChat.getSenderId());
    }
}
