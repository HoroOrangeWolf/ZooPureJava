package com.Michalski.Minner.Mozdzierz.Ozga.User;

import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class UserService {

    private final UserRepository repository = new UserRepository();

    public void addUser(User user){
        if(repository.isEmailTaken(user.getEmail()))
            throw new IllegalStateException("Email is taken!");

        repository.save(user);
    }

    public void removeUser(Long id){
        repository.removeById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return repository.getUserByEmail(email);
    }

    public void updateUser(User user){
        repository.update(user);
    }

    public boolean isUserBok(Long id){
        return repository.isBokUser(id);
    }

}
