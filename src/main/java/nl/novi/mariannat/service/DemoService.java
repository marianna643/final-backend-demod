package nl.novi.mariannat.service;

import nl.novi.mariannat.domain.Demo;
import nl.novi.mariannat.payload.response.DemoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface DemoService {
    ResponseEntity uploadDemoToDir(MultipartFile file, Principal principal, String name, String email, String message, String artist, String titel) throws IOException;
    List<Demo> getAllDemos();
    Demo getDemoById(long id);
    List<Demo> getAllDemosForUser(Principal principal);
    ResponseEntity<DemoResponse> updateDemo(long id, String feedback);
}
