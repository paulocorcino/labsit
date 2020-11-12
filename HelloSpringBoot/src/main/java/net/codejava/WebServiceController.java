package net.codejava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceController {

    @GetMapping("/rest")
    public String sayRest(){
        return "Great, let's take  a Rest Spring Boot";
    }
}
