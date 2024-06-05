package org.mild.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 史偕成
 * @date 2024/05/25 11:04
 **/
//@EnableDiscoveryClient
@SpringBootApplication
public class MildSystemApp {
    public static void main(String[] args) {
        SpringApplication.run(MildSystemApp.class, args);
    }

}
