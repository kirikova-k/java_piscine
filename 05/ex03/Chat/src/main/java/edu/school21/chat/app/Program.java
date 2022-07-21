package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("ogarthar");
        ds.setPassword("");



        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        Message m = repository.findById(10L).get();
        User newAuthor = new User(6, "lol", "lol", new ArrayList<>(), new ArrayList<>());
        m.setAuthor(newAuthor);

        repository.update(m);

        ds.close();
    }
}