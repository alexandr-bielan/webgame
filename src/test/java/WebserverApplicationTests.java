import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest
public class WebserverApplicationTests {
    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        SpringApplication.run(WebserverApplicationTests.class, args);
    }

}