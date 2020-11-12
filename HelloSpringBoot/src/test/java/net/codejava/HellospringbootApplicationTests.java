package net.codejava;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

@SpringBootTest
class HellospringbootApplicationTests {

    @Autowired
    private WebController controller;

    @Test
    void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }


}
