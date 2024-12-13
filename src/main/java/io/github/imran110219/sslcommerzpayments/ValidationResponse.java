package io.github.imran110219.sslcommerzpayments;

import lombok.Data;

@Data
public class ValidationResponse {
    private String status;
    private String sessionkey;
    private String tran_date;
    private String tran_id;
    private String val_id;
    private String amount;
    private String store_amount;
    private String bank_tran_id;
    private String card_type;
    private String card_no;
    private String card_issuer;
    private String card_brand;
    private String card_issuer_country;
    private String card_issuer_country_code;
    private String currency_type;
    private String currency_amount;
    private String currency_rate;
    private String base_fair;
    private String value_a;
    private String value_b;
    private String value_c;
    private String value_d;
    private String risk_title;
    private String risk_level;
    private String APIConnect;
    private String validated_on;
    private String gw_version;
}
