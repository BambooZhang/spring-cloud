package bamboo;


import bamboo.filter.MyGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


/**
 * 使用Gateway 作为网关服务,替代zuul
 *
 * 这里是一个服务启动类
 *
 * Created by xialeme on 2018/9/28.
 */

@SpringBootApplication
public class GatewayServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(t -> t.path("/hello")//路由地址
                        .filters(f -> f.stripPrefix(2)//绑定拦截器
                                .filter(new MyGatewayFilter())
                                .addResponseHeader("X-Response-test", "test"))
//                        .and()
 .uri("http://localhost:8501") //映射的真实地址
                        .order(0)//拦截器的顺序
                )
               /* .route(t -> t.path("/baidu")
                        .and()
                        .uri("http://baidu.com:80/"))*/
                .build();
    }

}
