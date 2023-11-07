package com.example;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity(name = "app_user")
@NoArgsConstructor
@Setter
@Getter
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;

    public User(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
}
