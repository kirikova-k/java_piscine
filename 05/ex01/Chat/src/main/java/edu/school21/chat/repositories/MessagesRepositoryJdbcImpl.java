package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        Connection connection = ds.getConnection();

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM chat.msgs WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        User user = new User(1, "ogarthar", "qwerty", null, null);
        Chatroom chatroom = new Chatroom(1, "chatroom", null, null);
        try {
            optionalMessage = Optional.of(new Message(resultSet.getInt(1), user, chatroom, resultSet.getString("message"), LocalDateTime.of(2014, 9, 19, 14, 5)));
            return optionalMessage;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return Optional.empty();
    }
}
