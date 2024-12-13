package io.github.imran110219.sslcommerzpayments;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
