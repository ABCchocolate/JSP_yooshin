package springapp2.cook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springapp2.config.AppConfig;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cook cook = context.getBean(Cook.class);
        cook.makeFood();
    }
}
