package com.NikSoftelevation.springbootreactjsfullstack.service;

import com.NikSoftelevation.springbootreactjsfullstack.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUserByUserId(Long userId);

    public User updateUser(User user, Long userId);

    public void deleteUserByUserId(Long userId);
}
