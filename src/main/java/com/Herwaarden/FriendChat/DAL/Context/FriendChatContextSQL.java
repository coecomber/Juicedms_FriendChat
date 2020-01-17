package com.Herwaarden.FriendChat.DAL.Context;

import com.Herwaarden.FriendChat.DAL.Interface.Context.IFriendChatContext;
import com.Herwaarden.FriendChat.Model.FriendChat;
import com.Herwaarden.FriendChat.Model.FriendsChat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FriendChatContextSQL implements IFriendChatContext {
    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    public FriendChatContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/friendChatDB";
        usernameUrl = "root";
        passwordUrl = "varken";
    }

    @Override
    public FriendsChat getAllChats() {
        FriendsChat friendsChat = new FriendsChat();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM friendchattable;";

            // create the java statement
            try (PreparedStatement cst = conn.prepareCall(query))
            {
                try (ResultSet rs = cst.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        FriendChat friendChat = new FriendChat();

                        friendChat.setMessage(rs.getString("message"));
                        friendChat.setReceiverId(rs.getInt("receiverId"));
                        friendChat.setSenderId(rs.getInt("senderId"));

                        friendsChat.getFriendChatList().add(friendChat);
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendChatContextSQL.getAllChats().");
            System.err.println(e.getMessage());
        }

        return friendsChat;
    }

    @Override
    public boolean addMessage(int senderId, int receiverId, String message) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "INSERT INTO friendchattable(senderId, receiverId, message) VALUES (?, ?, ?);";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                cst.setInt(1, senderId);
                cst.setInt(2, receiverId);
                cst.setString(3, message);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendChatContextSQL.addMessage().");
            System.err.println(e.getMessage());
        }

        return false;
    }
}
