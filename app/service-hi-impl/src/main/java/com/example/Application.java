package com.example;

import java.util.Arrays;

import com.yylc.prodcore.common.service.api.ProductQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    @Bean
    public HessianProxyFactoryBean getClient() {
        HessianProxyFactoryBean bean = new HessianProxyFactoryBean();
        bean.setServiceInterface(ProductQueryService.class);
        bean.setServiceUrl("http://192.168.2.150:7070/prodcore2/productQueryService#__hs=3");
        //bean.setServiceUrl("http://localhost:8087/prodcore2/productQueryService#__hs=3");
        return bean;
    }

}
