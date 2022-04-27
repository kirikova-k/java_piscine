package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    int id;
    String login;
    String password;
    List<Chatroom> createdChatrooms;
    List<Chatroom> joinedChatrooms;

    public User(int id, String login, String password, List<Chatroom> createdChatrooms, List<Chatroom> joinedChatrooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdChatrooms = createdChatrooms;
        this.joinedChatrooms = joinedChatrooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdChatrooms=" + createdChatrooms +
                ", joinedChatrooms=" + joinedChatrooms +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdChatrooms, joinedChatrooms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createdChatrooms, user.createdChatrooms) && Objects.equals(joinedChatrooms, user.joinedChatrooms);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedChatrooms() {
        return createdChatrooms;
    }

    public void setCreatedChatrooms(List<Chatroom> createdChatrooms) {
        this.createdChatrooms = createdChatrooms;
    }

    public List<Chatroom> getJoinedChatrooms() {
        return joinedChatrooms;
    }

    public void setJoinedChatrooms(List<Chatroom> joinedChatrooms) {
        this.joinedChatrooms = joinedChatrooms;
    }
}