package br.edu.ibmec.cloud.nuvem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumentationConfiguration {
    
    @Bean
    public OpenAPI apiDocConfig(){
        return new OpenAPI()
            .info(new Info()
                    .title("AP1 Big Data e Cloud Computing")
                    .description("api em springboot")
                    .version("1.0")
                    .contact(new Contact()
                            .name("Leonardo Tims Carneiro Campello")
                            .email("leomengo2002@gmail.com")));
    }
    
}
