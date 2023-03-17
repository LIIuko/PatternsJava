package task10.src.main.java.ru.trader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task10.src.main.java.ru.trader.Config.BeanConfig;
import task10.src.main.java.ru.trader.components.Fighter;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        Fighter g = (Fighter) applicationContext.getBean("StreetFighter");
        Fighter d = (Fighter) applicationContext.getBean("Boxer");
        Fighter t = (Fighter) applicationContext.getBean("Judoka");

        g.doFight();
        d.doFight();
        t.doFight();
    }
}
