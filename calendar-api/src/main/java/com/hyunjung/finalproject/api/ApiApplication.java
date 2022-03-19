package com.hyunjung.finalproject.api;

import com.hyunjung.finalproject.core.SimpleEntity;
import com.hyunjung.finalproject.core.SimpleEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EntityScan("com.hyunjung.finalproject.core")
@EnableJpaRepositories("com.hyunjung.finalproject.core")
@RestController
@SpringBootApplication
public class ApiApplication {

    private final SimpleEntityRepository repository;

    public ApiApplication(SimpleEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SimpleEntity> findAll(){
        return repository.findAll();
    }
    @PostMapping("/save")
    public SimpleEntity saveOne(){
        final SimpleEntity e =  new SimpleEntity();
        e.setName("hello");
        return repository.save(e);
    }

    public static void main(String[] args){
        SpringApplication.run(ApiApplication.class,args);
    }
}
