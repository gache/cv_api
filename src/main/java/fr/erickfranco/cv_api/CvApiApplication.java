package fr.erickfranco.cv_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({@PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true)})
public class CvApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CvApiApplication.class, args);
    }

//    @Autowired
//    private UserServiceInter userServiceInter;


    @Override
    public void run(String... args) throws Exception {

//        Optional<User> user = userServiceInter.findByLogin("admin");
//
//        if (!user.isPresent()) {
//            User user1 = new User();
//            user1.setNom("userFranco");
//            user1.setPrenom("userErick");
//            user1.setLogin("admin");
//            user1.setAdmin(true);
//            user1.setPassword("admin");
//            user1.setEmail("elgache@hotmail.com");
//
//            User output = userServiceInter.saveUser(user1);
//            System.out.println("hello");
//        }

    }
}
