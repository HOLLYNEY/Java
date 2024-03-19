package HW.WWC;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@SpringBootApplication

public class Controller_Get {
    @GetMapping("/get")
    public ResponseEntity<?> getStaticJson() {
        User user = new User("jojo", "bean");
        return ResponseEntity.ok(user);
    }



}
