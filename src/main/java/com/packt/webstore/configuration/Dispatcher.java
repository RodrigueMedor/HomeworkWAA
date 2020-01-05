package com.packt.webstore.configuration;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.packt.webstore.controller"})
public class Dispatcher extends WebMvcConfigurerAdapter {



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
           }
 
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
    
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean(name = "validator")
//    public LocalValidatorFactoryBean validator() {
//       LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//       bean.setValidationMessageSource(messageSource());
//       return bean;
//    }
//
//    @Override
//    public Validator getValidator(){
//       return validator();
//    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(phoneFormatter);
//    }
//
  
}
