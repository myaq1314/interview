package org.czh.interview.spring_boot_interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.TimeZone;

/**
 * @author : czh
 * description :
 * date : 2021-06-10
 * email 916419307@qq.com
 */
@RestController
@SpringBootApplication(scanBasePackages = {"org.czh.interview.spring_boot_interview"})
public class SpringBootInterviewApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SpringBootInterviewApplication.class, args);
    }

    @GetMapping("/")
    public String startTip() {
        return "spring boot interview api is running !!!";
    }
}
