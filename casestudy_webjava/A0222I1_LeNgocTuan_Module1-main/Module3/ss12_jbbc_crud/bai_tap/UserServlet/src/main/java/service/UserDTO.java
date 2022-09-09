package service;

import models.User;

import java.util.List;

public interface UserDTO {
    User searchUserById(int id);

    void insertUser(String name,String email,String country);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getListUser(String query);
}
