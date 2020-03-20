package io.namoosori.auction.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuctionUserApp {
    //
    public static void main(String[] args) {
        SpringApplication.run(AuctionUserApp.class);
    }
}
