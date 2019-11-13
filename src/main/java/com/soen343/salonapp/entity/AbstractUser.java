package com.soen343.salonapp.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Accessors(fluent = true) @Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractUser extends AbstractBaseEntity {

    private String username;

    private String password;    // no security

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    public AbstractUser(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
