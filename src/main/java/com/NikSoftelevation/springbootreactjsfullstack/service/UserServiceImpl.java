package com.NikSoftelevation.springbootreactjsfullstack.service;

import com.NikSoftelevation.springbootreactjsfullstack.exception.ResourceNotFoundException;
import com.NikSoftelevation.springbootreactjsfullstack.model.User;
import com.NikSoftelevation.springbootreactjsfullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with userId " + userId + "not found!"));
    }

    @Override
    public User updateUser(User user, Long userId) {

        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with userId" + userId + "not found"));
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        User userToDelete = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with userId" + userId + "not found"));
        userRepository.delete(userToDelete);
    }
}
