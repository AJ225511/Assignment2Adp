package Config;

import wiese.aj.CollectionInterface;
import wiese.aj.WithSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "spring")
    public CollectionInterface getCollection() {
        return new WithSpring();
    }
}