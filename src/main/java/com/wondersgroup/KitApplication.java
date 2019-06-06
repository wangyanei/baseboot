package com.wondersgroup;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "com.wondersgroup")
@ServletComponentScan
@MapperScan("com.wondersgroup.*.dao")
public class KitApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitApplication.class, args);
	}

}
