package io.github.imran110219.sslcommerzpayments;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "sslcommerz")
public class SSLCommerzProperties {

    private String storeId;
    private String storePassword;
    private boolean testMode;
    private Transaction transaction;
    private Api api;

    @Data
    public static class Transaction {
        private String currency;
        private String successUrl;
        private String failUrl;
        private String cancelUrl;
    }

    @Data
    public static class Api {
        private Endpoint sandbox;
        private Endpoint production;
        private String initiateTransactionPath;
        private String validateTransactionPath;
        private String refundTransactionPath;

        @Data
        public static class Endpoint {
            private String baseUrl;
        }
    }
}