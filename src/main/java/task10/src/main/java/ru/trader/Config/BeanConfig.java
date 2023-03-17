package task10.src.main.java.ru.trader.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import task10.src.main.java.ru.trader.components.Boxer;
import task10.src.main.java.ru.trader.components.Judoka;
import task10.src.main.java.ru.trader.components.StreetFighter;

@Configuration
@ComponentScan
public class BeanConfig {

    @Bean("StreetFighter")
    public StreetFighter streetFighter(){
        return new StreetFighter();
    }

    @Bean("Boxer")
    public Boxer boxer(){
        return new Boxer();
    }

    @Bean("Judoka")
    public Judoka judoka(){
        return new Judoka();
    }
}
