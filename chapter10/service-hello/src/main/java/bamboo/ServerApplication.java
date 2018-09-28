package bamboo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 这里是一个服务启动类
 *
 * Created by xialeme on 2018/9/28.
 */

@SpringBootApplication
@RestController
public class ServerApplication {

    @RequestMapping("/hello")
    public String home() {
        return "hello servie-hello ";
    }

    @RequestMapping("/health")
    public String health() {
        return "hello health ";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }


}
