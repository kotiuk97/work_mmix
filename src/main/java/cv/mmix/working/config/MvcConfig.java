package cv.mmix.working.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {
//public class MvcConfig{

    @Value("${slide.images.upload.path}")
    private String sliderUploadPath;

    @Value("${users.images.upload.path}")
    private String userUploadPath;


//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/rabota").setViewName("rabota");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/users/**")
                .addResourceLocations("file://" + userUploadPath + "/");

        registry.addResourceHandler("/img/slider/**")
                .addResourceLocations("file://" + sliderUploadPath + "/");


    }


}
