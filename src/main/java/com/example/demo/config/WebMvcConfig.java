package com.example.demo.config;

import com.example.demo.MainFlowHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.AjaxThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
    
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
    }
    
    //Uruchamia flow o tej nazwie, po wejściu na ten URL
    @Bean(name = "/main-flow")
    public MainFlowHandler firmFlowHandler()
    {
        return new MainFlowHandler();
    }
    
    
    /*
     * Należy skonfigurować viewResolver bo jest on potem
     * używany w klasie FlowWebConfig, w beanie
     * mvcViewFactoryCreator
     * */
    
    @Bean
    public AjaxThymeleafViewResolver viewResolver()
    {
        AjaxThymeleafViewResolver viewResolver = new AjaxThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    
    @Bean
    public ServletContextTemplateResolver templateResolver()
    {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
}
