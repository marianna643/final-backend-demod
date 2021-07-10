package nl.novi.mariannat;

import nl.novi.mariannat.payload.request.SignupRequest;
import nl.novi.mariannat.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseFiller implements CommandLineRunner {

    private final AuthorizationService authorizationService;

    @Autowired
    public DatabaseFiller(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        Set<String> rollen = new HashSet<>();
        rollen.add("admin");

        SignupRequest admin = new SignupRequest();
        admin.setUsername("admin");
        admin.setEmail("admin@admin.nl");
        admin.setPassword("admin1234");
        admin.setCountry("Nederland");
        admin.setFirstName("Admin");
        admin.setLastName("Diablo");
        admin.setRole(rollen);
        authorizationService.registerUser(admin);

        SignupRequest user = new SignupRequest();
        user.setUsername("testuser");
        user.setEmail("testuser@test.nl");
        user.setPassword("test1234");
        user.setCountry("Nederland");
        user.setFirstName("testuser");
        user.setLastName("Demo");
        rollen.remove("admin");
        rollen.add("user");
        user.setRole(rollen);
        authorizationService.registerUser(user);

    }
}