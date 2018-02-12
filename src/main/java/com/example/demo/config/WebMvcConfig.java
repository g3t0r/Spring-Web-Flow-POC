package com.example.demo.config;

import com.example.demo.MainFlowHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.AjaxThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
    
    public void addViewControllers(ViewControllerRegistry registry)
    {
        //registry.addViewController("/first").setViewName("first");
        //registry.addViewController("/second").setViewName("second");
        //registry.addViewController("/summary").setViewName("summary");
        registry.addViewController("/").setViewName("index");
    }
    
    @Bean(name = "/main-flow")
    public MainFlowHandler firmFlowHandler()
    {
        return new MainFlowHandler();
    }
    
    /*
    * Do lokalizowania flow domyślnie jest używany ServletContextTemplateResolver,
    * nie znalazłem możliwości zmienienia go na ClassLoaderTemplateResolver.
    * Widoki z których korzysta flow powinny znajdować się razem z plikiem *-flow.xml,
    * z tego powodu nietypowa ścieżka do zasobów
    * */
    
    
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/", "classpath:/webapp/");
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
    
    @Bean
    public AjaxThymeleafViewResolver viewResolver()
    {
       AjaxThymeleafViewResolver viewResolver = new AjaxThymeleafViewResolver();
       viewResolver.setTemplateEngine(templateEngine());
       viewResolver.setCharacterEncoding("UTF-8");
       return viewResolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine(){
        
        //Set<IDialect> dialects = new LinkedHashSet<IDialect>();
        //dialects.add(new ConditionalCommentsDialect());
        
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        //templateEngine.setAdditionalDialects(dialects);
        return templateEngine;
    }
    
    
    
}
