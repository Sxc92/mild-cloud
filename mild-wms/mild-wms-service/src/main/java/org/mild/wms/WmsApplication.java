package org.mild.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description 仓储相关业务模块
 * @create 2023/11/28 9:23
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmsApplication.class, args);
    }
}
