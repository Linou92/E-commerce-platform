package se.lexicon.E_commerce_platform.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ecommerceOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce Platform API")
                        .version("v1")
                        .description("REST API for the E-commerce Platform"));
    }
}
