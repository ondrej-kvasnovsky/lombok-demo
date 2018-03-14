import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserService {

    public User create(Long id, String email) {
        return new User(id, email);
    }

    public Set<User> uniqueUsers(List<User> users) {
        return new HashSet<>(users);
    }

    private HashSet<User> users = new HashSet<>();

    {
        users.add(new User(1L, "john@john.com"));
        users.add(new User(2L, "jimmy@jimmy.com"));
        users.add(new User(3L, "julia@julia.com"));
    }

    public String findUserEmailById(Long id) {
        List<User> results = users.stream()
                .filter(user -> user.getId().equals(id))
                .collect(Collectors.toList());
        if (!results.isEmpty()) {
            User foundUser = results.get(0);
            return foundUser.getEmail();
        }
        return null;
    }
}
