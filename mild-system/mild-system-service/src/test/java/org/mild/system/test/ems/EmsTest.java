package org.mild.system.test.ems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description
 * @create 2023/11/28 9:23
 */
@SpringBootTest
public class EmsTest {

    /**
     * @description 获取计算机设备的唯一信息
     */
    @Test
    void getComputerSole() throws IOException {
        String cpuId;
        // 获取当前操作系统名称
        String os = System.getProperty("os.name");
        os = os.toUpperCase();
        System.out.println(os);
        Process process = Runtime.getRuntime().exec(
                new String[]{"wmic", "cpu", "get", "ProcessorId"});
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        sc.next();
        String serial = sc.next();
        System.out.println(serial);
    }



}
