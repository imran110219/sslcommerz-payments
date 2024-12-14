package io.github.imran110219.sslcommerzpayments;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(SSLCommerzProperties.class)
public class SSLCommerzConfiguration {
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public SSLCommerzService sslCommerzService(WebClient.Builder webClientBuilder, SSLCommerzProperties sslCommerzProperties) {
        return new SSLCommerzService(webClientBuilder, sslCommerzProperties);
    }
}
