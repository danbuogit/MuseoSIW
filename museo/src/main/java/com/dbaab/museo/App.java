package com.dbaab.museo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dbaab.museo.model.Admin;
import com.dbaab.museo.service.AdminService;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
//  @Bean
//	public CommandLineRunner demo(AdminService service) {
//		return (args) -> {
//			
//	        Admin a = new Admin();
//	        a.setId(1);
//	        a.setName("danbuo");
//	        a.setPassword("danbuo");
//			service.save(a);
//		};
//	}
}
