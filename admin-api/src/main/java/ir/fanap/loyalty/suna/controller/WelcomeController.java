package ir.fanap.loyalty.suna.admin.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")

public class WelcomeController {

    @GetMapping("/welcome")
    public String greeting() throws Exception {
        if (true)
            throw new Exception("exception");
        return "";
    }


}