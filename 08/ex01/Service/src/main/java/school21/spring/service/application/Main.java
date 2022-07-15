package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;

import javax.sql.DataSource;
import java.lang.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final List<User> testUsers = createTestUsers();

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
            UsersRepository usersRepositoryJdbc = context.getBean("usersRepositoryJdbc", UsersRepository.class);
            DriverManagerDataSource ds = context.getBean("DriverManagerDataSource", DriverManagerDataSource.class);
            System.out.println("---JDBC repository tests----");
            runTests(usersRepositoryJdbc, ds);

            UsersRepository jdbcTemplate = context.getBean("usersRepositoryJdbcTemplate", UsersRepositoryJdbcTemplateImpl.class);
            System.out.println("---JDBCTemplate repository tests----");
            runTests(jdbcTemplate, ds);
        }
    }
    public static void pupulateDb(UsersRepository usersRepository, List<User> testUsers) {
        for (User user : testUsers) {
            usersRepository.save(user);
        }
    }

    private static List<User> createTestUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1l, "aaaaa"));
        users.add(new User(2l, "bbbbbb"));
        users.add(new User(3l, "cccccc"));
        users.add(new User(4l, "44vzw445oo@oreple.com"));
        users.add(new User(5l, "55vzw445oo@oreple.com"));
        users.add(new User(6l, "66vzw445oo@oreple.com"));
        users.add(new User(7l, "77vzw445oo@oreple.com"));
        return users;
    }
    private static void createTableInDb(DataSource ds) {
        try (Connection conn = ds.getConnection();
             PreparedStatement drop = conn.prepareStatement("drop table if exists public.user");
             PreparedStatement create = conn.prepareStatement("create table public.user (identifier int, email varchar(30))");) {
            drop.executeUpdate();
            create.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to create table: " + e);
        }
    }
    private static void runTests(UsersRepository repository, DataSource ds) {
        createTableInDb(ds);
        pupulateDb(repository, testUsers);
        List<User> usersFromDataBase = repository.findAll();
        System.out.println("---JDBC repository test---");
        System.out.println("---findAll---");
        if (testUsers.equals(usersFromDataBase)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("---findById()---");
        User result1 = repository.findById(1L);
        User result2 = repository.findById(2L);
        User result3 = repository.findById(3L);
        User result4 = repository.findById(1000L);
        if (result1.equals(testUsers.get(0))
                && result2.equals(testUsers.get(1))
                && result3.equals(testUsers.get(2))
                && result4 == null) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("---update()---");
        User userForUpdate = new User(1L, "updated@update.com");
        repository.update(userForUpdate);
        User updatedUser = repository.findById(1L);
        if (updatedUser.equals(userForUpdate)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("---delete()---");
        repository.delete(1L);
        repository.delete(2L);
        repository.delete(3L);
        User deletedUser = repository.findById(1L);
        User deletedUser1 = repository.findById(1L);
        User deletedUser2 = repository.findById(1L);
        if (deletedUser == null && deletedUser1 == null && deletedUser2 == null) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("---findByEmail()---");
        Optional<User> userFoundByEmail1 = repository.findByEmail(testUsers.get(4).getEmail());
        Optional<User> userFoundByEmail2 = repository.findByEmail(testUsers.get(5).getEmail());
        Optional<User> userFoundByEmail3 = repository.findByEmail(testUsers.get(6).getEmail());
        if (userFoundByEmail1.isPresent() && userFoundByEmail2.isPresent() && userFoundByEmail3.isPresent()) {
            if (userFoundByEmail1.get().equals(testUsers.get(4))
                    && userFoundByEmail1.get().equals(testUsers.get(5))
                    && userFoundByEmail1.get().equals(testUsers.get(6))) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }
            System.out.println("FAIL");
        }
    }
}
