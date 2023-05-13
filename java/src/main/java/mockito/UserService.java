package mockito;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );
    }
}
