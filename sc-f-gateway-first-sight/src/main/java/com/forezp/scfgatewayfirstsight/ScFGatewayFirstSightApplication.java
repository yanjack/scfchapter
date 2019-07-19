package com.forezp.scfgatewayfirstsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class ScFGatewayFirstSightApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScFGatewayFirstSightApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(p -> p
//                    .path("/get")
//                    .filters(f -> f.addRequestHeader("hello","word"))
//                    .uri("http://httpbin.org:80"))
//                .route(p -> p
//                    .path("*hystrix")
//                    .filters(f -> f
//                        .hystrix(config -> config
//                            .setName("mycmd")
//                            .setFallbackUri("forward:/fallback")))
//                    .uri("http://httpbin.org:80"))
//                .build();
//    }

    @RequestMapping("/fallback")
    public String fallback(){
        System.out.println("-------------------");
        return "fallback";
    }
}
