package comm.bamboo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 服务端hello
 *
 *  service-hello Application
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/hello")
    public String home(String name ) {
        return "hello "+name+"from port:" +port;
    }



}

