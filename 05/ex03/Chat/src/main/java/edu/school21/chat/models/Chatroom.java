package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private int id;
    private String chatName;
    private User owner;
    private List<Message> messageList;

    public Chatroom(int id, String chatName, User owner, List<Message> messageList) {
        this.id = id;
        this.chatName = chatName;
        this.owner = owner;
        this.messageList = messageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return id == chatroom.id && Objects.equals(chatName, chatroom.chatName) && Objects.equals(owner, chatroom.owner) && Objects.equals(messageList, chatroom.messageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatName, owner, messageList);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                ", owner=" + owner +
                ", messageList=" + messageList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}