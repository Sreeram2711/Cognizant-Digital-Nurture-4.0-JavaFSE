
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


import java.util.Map;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable("number") String number) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        response.put("type", "SAVINGS");
        response.put("balance", 200043);
        return response;
    }
}
