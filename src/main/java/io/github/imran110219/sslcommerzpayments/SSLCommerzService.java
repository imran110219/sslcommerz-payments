package io.github.imran110219.sslcommerzpayments;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SSLCommerzService {

    private static final Logger logger = LoggerFactory.getLogger(SSLCommerzService.class);

    private final WebClient.Builder webClientBuilder;
    private final SSLCommerzProperties sslCommerzProperties;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        String baseUrl = sslCommerzProperties.isTestMode()
                ? sslCommerzProperties.getApi().getSandbox().getBaseUrl()
                : sslCommerzProperties.getApi().getProduction().getBaseUrl();
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public TransactionResponse initiateTransaction(TransactionRequest request) {
        request.setStore_id(sslCommerzProperties.getStoreId());
        request.setStore_passwd(sslCommerzProperties.getStorePassword());
        request.setSuccess_url(sslCommerzProperties.getTransaction().getSuccessUrl());
        request.setFail_url(sslCommerzProperties.getTransaction().getFailUrl());
        request.setCancel_url(sslCommerzProperties.getTransaction().getCancelUrl());
        request.setCurrency(sslCommerzProperties.getTransaction().getCurrency());

        logger.info("Initiating transaction with ID: {}", request.getTran_id());

        return this.webClient.post()
                .uri(sslCommerzProperties.getApi().getInitiateTransactionPath())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(buildFormData(request))
                .retrieve()
                .bodyToMono(TransactionResponse.class)
                .block();
    }

    public Mono<ValidationResponse> validateTransaction(String tranId) {
        String url = String.format("%s?val_id=%s&store_id=%s&store_passwd=%s&format=json",
                sslCommerzProperties.getApi().getValidateTransactionPath(), tranId,
                sslComSSLCommerzmerzProperties.getStoreId(), sslCommerzProperties.getStorePassword());

        logger.info("Validating transaction with ID: {}", tranId);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(ValidationResponse.class)
                .doOnError(e -> logger.error("Error validating transaction: {}", e.getMessage()));
    }

    public Mono<RefundResponse> validateRefund(String bankTranId, String refundAmount, String refundRemarks) {
        String url = String.format("%s?bank_tran_id=%s&refund_amount=%s&refund_remarks=%s&store_id=%s&store_passwd=%s&v=1&format=json",
                sslCommerzProperties.getApi().getRefundTransactionPath(), bankTranId, refundAmount, refundRemarks,
                sslCommerzProperties.getStoreId(), sslCommerzProperties.getStorePassword());

        logger.info("Processing refund for Bank Tran ID: {}", bankTranId);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(RefundResponse.class)
                .doOnError(e -> logger.error("Error processing refund: {}", e.getMessage()));
    }

    private BodyInserters.FormInserter<String> buildFormData(TransactionRequest request) {
        return BodyInserters.fromFormData("store_id", request.getStore_id())
                .with("store_passwd", request.getStore_passwd())
                .with("total_amount", request.getTotal_amount())
                .with("currency", request.getCurrency())
                .with("tran_id", request.getTran_id())
                .with("success_url", request.getSuccess_url())
                .with("fail_url", request.getFail_url())
                .with("cancel_url", request.getCancel_url())
                .with("cus_name", request.getCus_name())
                .with("cus_email", request.getCus_email())
                .with("cus_add1", request.getCus_add1())
                .with("cus_add2", request.getCus_add2())
                .with("cus_city", request.getCus_city())
                .with("cus_state", request.getCus_state())
                .with("cus_postcode", request.getCus_postcode())
                .with("cus_country", request.getCus_country())
                .with("cus_phone", request.getCus_phone())
                .with("cus_fax", request.getCus_fax())
                .with("ship_name", request.getShip_name())
                .with("ship_add1", request.getShip_add1())
                .with("ship_add2", request.getShip_add2())
                .with("ship_city", request.getShip_city())
                .with("ship_state", request.getShip_state())
                .with("ship_postcode", request.getShip_postcode())
                .with("ship_country", request.getShip_country())
                .with("multi_card_name", request.getMulti_card_name())
                .with("shipping_method", request.getShipping_method())
                .with("product_name", request.getProduct_name())
                .with("product_category", request.getProduct_category())
                .with("product_profile", request.getProduct_profile())
                .with("value_a", request.getValue_a())
                .with("value_b", request.getValue_b())
                .with("value_c", request.getValue_c())
                .with("value_d", request.getValue_d());
    }
}
