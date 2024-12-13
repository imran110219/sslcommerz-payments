package io.github.imran110219.sslcommerzpayments;

import lombok.Data;

@Data
public class TransactionRequest {
    // Configuration parameters
    private String store_id;
    private String store_passwd;
    private String currency;
    private String success_url;
    private String fail_url;
    private String cancel_url;
    private String total_amount;
    private String tran_id;
    private String product_category;
    private String cus_name;
    private String cus_email;
    private String cus_add1;
    private String cus_add2;
    private String cus_city;
    private String cus_state;
    private String cus_postcode;
    private String cus_country;
    private String cus_phone;
    private String cus_fax;
    private String ship_name;
    private String ship_add1;
    private String ship_add2;
    private String ship_city;
    private String ship_state;
    private String ship_postcode;
    private String ship_country;
    private String multi_card_name;
    private String shipping_method;
    private String product_name;
    private String product_profile;
    private String value_a;
    private String value_b;
    private String value_c;
    private String value_d;
}