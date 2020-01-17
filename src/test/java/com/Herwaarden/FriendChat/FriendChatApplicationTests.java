package com.Herwaarden.FriendChat;

import com.Herwaarden.FriendChat.Logic.FriendChatLogic;
import com.Herwaarden.FriendChat.Model.MyFriendChat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FriendChatApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void TestGettingAllPlayers() throws Exception {
		FriendChatLogic friendChatLogic = new FriendChatLogic();

		mockMvc.perform(get("/api/chats/get/{userId}", 1)
				.contentType("application/json"));

		List<MyFriendChat> myFriendChatList = friendChatLogic.getChatsByUserId(1);
		for(MyFriendChat myFriendChat : myFriendChatList){
			assertThat(myFriendChat.getFriendId()).isAtLeast(1);
		}
	}
}
