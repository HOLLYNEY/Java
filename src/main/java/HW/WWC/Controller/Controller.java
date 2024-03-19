package HW.WWC.Controller;

import HW.WWC.Model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RequestMapping("/api")
@RestController
@SpringBootApplication

public class Controller {
    @GetMapping("/get")
    public ResponseEntity<?> getStaticJson() {
    User user = new User("jojo", "bean");
    return ResponseEntity.ok(user);
}
    @PostMapping("/processJson")
    public ResponseEntity<?> processJson(@RequestBody Map<String,String> userReq) {
        try {
            if((userReq.size()>2) || (!userReq.containsKey("login")) || (!userReq.containsKey("password"))){
                throw new Exception("BAD JSON");
            }
            User user = new User(userReq.get("login"),userReq.get("password"));
            return ResponseEntity.ok(user.toString());

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
