package model.users;

import databasse.ListOfUsers;

import java.util.HashMap;
import java.util.Set;

public abstract class User {
    public static Integer nextId = 0;
    private Integer id;
    private String name;
    private UserAtribute userAtribute;

    public User(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public User() {
    }

    public UserAtribute getUserAtribute() {
        return userAtribute;
    }

    public Integer getId() {
        return id;
    }

    public void setUserAtribute(UserAtribute userAtribute) {
        this.userAtribute = userAtribute;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userAtribute=" + userAtribute +
                '}';
    }
}
