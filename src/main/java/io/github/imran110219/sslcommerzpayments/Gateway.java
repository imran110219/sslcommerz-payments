package io.github.imran110219.sslcommerzpayments;

import lombok.Data;

@Data
public class Gateway {
    private String visa;
    private String master;
    private String amex;
    private String othercards;
    private String internetbanking;
    private String mobilebanking;
}
