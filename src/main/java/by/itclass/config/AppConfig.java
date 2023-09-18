package by.itclass.config;

import by.itclass.model.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc //для подключения всех аннотцаий web mvc
@ComponentScan(basePackages = "by.itclass")
public class AppConfig {
    @Bean
    public ViewResolver viewResolverJsp() {
        UrlBasedViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public Configuration configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }

    @Bean
    public SessionFactory factory(Configuration configuration) {
        SessionFactory factory = configuration.buildSessionFactory();
        return factory;
    }
}
