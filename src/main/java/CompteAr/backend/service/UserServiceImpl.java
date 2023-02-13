package CompteAr.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import CompteAr.backend.model.*;
import CompteAr.backend.repository.*;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        user.get().setPassword(userDetails.getPassword());
        user.get().setEmail(userDetails.getEmail());
        return userRepository.save(user.get());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userRepository.deleteById(id);
        return null;
    }
}