package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private static final String FIND_BY_ID_SQL = "select * from public.user where identifier=?";
    private static final String FIND_ALL_SQL = "select * from public.user";
    private static final String INSERT_SQL = "insert into public.user (identifier, email) values (?, ?)";
    private static final String UPDATE_SQL = "update public.user set email=? where identifier=?";
    private static final String DELETE_SQL = "delete from public.user where identifier=?";
    private static final String FIND_BY_EMAIL_SQL = "select * from public.user where email=";

    DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource ds) {

        this.dataSource = ds;
    }

    @Override
    public User findById(Long id) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                return new User(id, email);
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute find by id querry. Exception: " + e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String email = resultSet.getString(2);
                users.add(new User(id, email));
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute find all query with exception: " + e);
        }
        return users;
    }

    @Override
    public void save(User entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);) {
            preparedStatement.setLong(1, entity.getIdentifier());
            preparedStatement.setString(2, entity.getEmail());
            if (preparedStatement.executeUpdate() != 1) {
                throw new IllegalStateException("Update query ruturned 0 rows updated");
            }
        } catch (Exception e) {
            System.err.println("Failed to save user. Exception: " + e);
        }
    }

    @Override
    public void update(User entity) {

        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getIdentifier());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to update user: " + e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to execute delete query: " + e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM public.user WHERE email=";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql + '\'' + email + '\'');
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getLong(1),
                        resultSet.getString(2));
                return Optional .of(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
