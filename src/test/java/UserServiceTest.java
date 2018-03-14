import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void before() {
        userService = new UserService();
    }

    @Test
    public void returnsSetOfUniqueUsers() {
        List<User> duplicatedUsers = new ArrayList<>();
        duplicatedUsers.add(new User(1L, "john@john.com"));
        duplicatedUsers.add(new User(1L, "john@john.com"));
        duplicatedUsers.add(new User(2L, "jimmy@jimmy.com"));
        duplicatedUsers.add(new User(2L, "jimmy@jimmy.com"));

        Set<User> uniqueUsers = userService.uniqueUsers(duplicatedUsers);

        assertEquals(uniqueUsers.size(), 2);

        Iterator<User> it = uniqueUsers.iterator();
        User firstUser = it.next();
        assertEquals(Long.valueOf(1), firstUser.getId());

        User secondUser = it.next();
        assertEquals(Long.valueOf(2), secondUser.getId());
    }

    @Test
    public void findUserEmailById() {
        String foundEmail = userService.findUserEmailById(1L);

        assertEquals("john@john.com", foundEmail);
    }

    @Test
    public void createsNewUser() {
        User jimmy = userService.create(1L, "jimmy@jimmy.com");

        assertEquals(Long.valueOf(1), jimmy.getId());
        assertEquals("jimmy@jimmy.com", jimmy.getEmail());
    }

    @Test
    public void changesUserEmail() {
        User jimmy = new User(1L, "jimmy@jimmy.com");

        jimmy.setEmail("jimmy.awe@jimmy.com");

        assertEquals("jimmy.awe@jimmy.com", jimmy.getEmail());
    }

    @Test
    public void returnsToString() {
        User jimmy = new User(1L, "jimmy@jimmy.com");

        String toString = jimmy.toString();

        assertEquals("User(id=1)", toString);
    }

}