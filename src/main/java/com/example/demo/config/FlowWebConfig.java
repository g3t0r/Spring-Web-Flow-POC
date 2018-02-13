package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;

import java.util.Arrays;

@Configuration
public class FlowWebConfig extends AbstractFlowConfiguration
{
   
    @Autowired
    private WebMvcConfig webMvcConfig;
    
    
    @Bean
    public FlowDefinitionRegistry flowRegistry()
    {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
            .setBasePath("WEB-INF")
            .addFlowLocationPattern("*-flow.xml")
            .build();
    }
    
    @Bean
    public FlowExecutor flowExecutor()
    {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }
    
    @Bean
    public HandlerAdapter handlerAdapter()
    {
        FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
        flowHandlerAdapter.setFlowExecutor(flowExecutor());
        return flowHandlerAdapter;
    }
    
    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator()
    {
        MvcViewFactoryCreator viewFactoryCreator = new MvcViewFactoryCreator();
        viewFactoryCreator.setViewResolvers(Arrays.asList(this.webMvcConfig.viewResolver()));
        viewFactoryCreator.setUseSpringBeanBinding(true);
        return viewFactoryCreator;
    }
    
    @Bean
    public FlowBuilderServices flowBuilderServices()
    {
        return getFlowBuilderServicesBuilder()
            .setViewFactoryCreator(mvcViewFactoryCreator())
            .build();
    }
    
    
    
}
