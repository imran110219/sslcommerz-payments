package io.github.imran110219.sslcommerzpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransactionResponse {

    private String status;
    private String failedReason;
    private String sessionKey;
    private Gateway gw;
    private String redirectGatewayURL;
    private String directPaymentURLBank;
    private String directPaymentURLCard;
    private String directPaymentURL;
    private String redirectGatewayURLFailed;
    private String gatewayPageURL;
    private String storeBanner;
    private String storeLogo;
    private List<Description> desc;
    private String isDirectPayEnable;


    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("failedreason")
    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    @JsonProperty("sessionkey")
    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @JsonProperty("gw")
    public Gateway getGw() {
        return gw;
    }

    public void setGw(Gateway gw) {
        this.gw = gw;
    }

    @JsonProperty("redirectGatewayURL")
    public String getRedirectGatewayURL() {
        return redirectGatewayURL;
    }

    public void setRedirectGatewayURL(String redirectGatewayURL) {
        this.redirectGatewayURL = redirectGatewayURL;
    }

    @JsonProperty("directPaymentURLBank")
    public String getDirectPaymentURLBank() {
        return directPaymentURLBank;
    }

    public void setDirectPaymentURLBank(String directPaymentURLBank) {
        this.directPaymentURLBank = directPaymentURLBank;
    }

    @JsonProperty("directPaymentURLCard")
    public String getDirectPaymentURLCard() {
        return directPaymentURLCard;
    }

    public void setDirectPaymentURLCard(String directPaymentURLCard) {
        this.directPaymentURLCard = directPaymentURLCard;
    }

    @JsonProperty("directPaymentURL")
    public String getDirectPaymentURL() {
        return directPaymentURL;
    }

    public void setDirectPaymentURL(String directPaymentURL) {
        this.directPaymentURL = directPaymentURL;
    }

    @JsonProperty("redirectGatewayURLFailed")
    public String getRedirectGatewayURLFailed() {
        return redirectGatewayURLFailed;
    }

    public void setRedirectGatewayURLFailed(String redirectGatewayURLFailed) {
        this.redirectGatewayURLFailed = redirectGatewayURLFailed;
    }

    @JsonProperty("GatewayPageURL")
    public String getGatewayPageURL() {
        return gatewayPageURL;
    }

    public void setGatewayPageURL(String gatewayPageURL) {
        this.gatewayPageURL = gatewayPageURL;
    }

    @JsonProperty("storeBanner")
    public String getStoreBanner() {
        return storeBanner;
    }

    public void setStoreBanner(String storeBanner) {
        this.storeBanner = storeBanner;
    }

    @JsonProperty("storeLogo")
    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    @JsonProperty("desc")
    public List<Description> getDesc() {
        return desc;
    }

    public void setDesc(List<Description> desc) {
        this.desc = desc;
    }

    @JsonProperty("is_direct_pay_enable")
    public String getIsDirectPayEnable() {
        return isDirectPayEnable;
    }

    public void setIsDirectPayEnable(String isDirectPayEnable) {
        this.isDirectPayEnable = isDirectPayEnable;
    }
}
