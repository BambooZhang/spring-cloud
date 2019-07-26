package bamboo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局拦截器，它会作用于所有路由的连接路径
 *
 * 直接使用注解或者在spring config 中配置bean
 *
 * @Component注解，另外一种可以在 Spring Config 中配置这个 Bean如下所示:
 @Bean
 public MyGlobleFilter myGlobleFilter(){
 return new MyGlobleFilter();
 }
 测
 *
 * 调用鉴权
 */
@Component
public class MyGlobleFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("请求参数:"+exchange.getRequest().toString());
        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }
}