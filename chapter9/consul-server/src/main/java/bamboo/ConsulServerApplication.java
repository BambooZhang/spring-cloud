package bamboo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用consul作为服务注册发现中心
 *
 * 这里是一个服务启动类
 *
 * Created by xialeme on 2017/11/22.
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulServerApplication {

    @RequestMapping("/hi")
    public String home() {
        return "hello ConsulServer ";
    }

    @RequestMapping("/health")
    public String health() {
        return "hello health ";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulServerApplication.class).web(true).run(args);
    }


}
