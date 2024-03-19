package HW.WWC;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController

@SpringBootApplication

public class Controller_Post {
    @PostMapping("/processJson")
    public ResponseEntity<?> processJson(@RequestBody User userReq) {
        if (userReq == null || userReq.getLogin().isEmpty() || userReq.getPassword().isEmpty()|| userReq.getLogin().trim().isEmpty() || userReq.getPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("400 Bad Request error ");
        }

        return ResponseEntity.ok(userReq);
    }




}
