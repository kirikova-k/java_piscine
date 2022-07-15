package school21.spring.service.models;

import java.util.Objects;

public class User {

    private Long identifier;
    private String email;

    public User() {
        this.identifier = 0l;
        this.email = "";
    }

    public User(String email) {
        this.identifier = 0l;
        this.email = email;
    }

    public User(Long identifier, String email) {
        this.identifier = identifier;
        this.email = email;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return identifier.equals(user.identifier) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return "User{" +
                "Identifier=" + identifier +
                ", Email='" + email + '\'' +
                '}';
    }
}
