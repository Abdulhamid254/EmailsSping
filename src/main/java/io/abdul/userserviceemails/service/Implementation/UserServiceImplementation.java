package io.abdul.userserviceemails.service.Implementation;

import io.abdul.userserviceemails.domain.Confirmation;
import io.abdul.userserviceemails.domain.User;
import io.abdul.userserviceemails.repository.ConfirmationRepository;
import io.abdul.userserviceemails.repository.UserRepository;
import io.abdul.userserviceemails.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository; // dependency injection
    private final ConfirmationRepository confirmationRepository;
    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) { throw new RuntimeException("Email already exists!!");}
        user.setEnabled(false);
        userRepository.save(user);


        Confirmation confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);

        //TODO send email to user with token
        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
        // confirmationRepository.delete(confirmation)
        return Boolean.TRUE;
    }
}
