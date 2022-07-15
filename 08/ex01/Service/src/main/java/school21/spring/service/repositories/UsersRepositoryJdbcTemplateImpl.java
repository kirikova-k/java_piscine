package school21.spring.service.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.service.models.User;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public User findById(Long id) {
        try {
            return (User)jdbcTemplate.queryForObject("select * from public.user where identifier=?", new BeanPropertyRowMapper(User.class), new Object[]{id});
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from public.user", new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into public.user values (?, ?)", user.getIdentifier(), user.getEmail());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update public.user set email = ? where identifier = ?", user.getEmail(), user.getIdentifier());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from public.user where identifier = ?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = (User)jdbcTemplate.queryForObject("select * from public.user where email = ?", new BeanPropertyRowMapper<>(User.class), new Object[]{email});
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}