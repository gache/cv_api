package fr.erickfranco.cv_api.configurations.exceptionconfig.jacksonconfig;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Hibernate5Module getHibernate5Module() {
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        return hibernate5Module;
    }
}
