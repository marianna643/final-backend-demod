package nl.novi.mariannat.service;

import nl.novi.mariannat.domain.User;
import nl.novi.mariannat.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(4);
        user.setUsername("user500");
        user.setEmail("user500@user.nl");
        user.setPassword("hallo1234");

        user = new User();
        user.setId(5);
        user.setUsername("test600");
        user.setEmail("test600@test.nl");
        user.setPassword("hallo8765");

    }

    @Test
    public void whenFindById_ReturnUsername() {

        Mockito
                .when(userRepository.existsById((long) 4))
                .thenReturn(true);

        Mockito
                .when(userRepository.findById((long) 4))
                .thenReturn(Optional.of(user));

        Assertions.assertEquals(userServiceImpl.getUserById(4).getUsername(), user.getUsername());

    }

    @Test
    public void whenFindByIdNotFound_Return404() {

        Mockito
                .when(userRepository.existsById((long) 5))
                .thenReturn(true);

        Mockito
                .when(userRepository.existsById((long) 6))
                .thenReturn(false);

        Mockito
                .when(userRepository.findById((long) 6))
                .thenReturn(null);

        User noUser = userServiceImpl.getUserById(user.getId());

        Assertions.assertNull(noUser, "404");

    }

}
