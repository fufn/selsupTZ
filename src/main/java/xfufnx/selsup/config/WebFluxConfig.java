package xfufnx.selsup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://ismp.crpt.ru/api/v3")
                .build();
    }
}
