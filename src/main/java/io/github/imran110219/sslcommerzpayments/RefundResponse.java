package io.github.imran110219.sslcommerzpayments;

import lombok.Data;

@Data
public class RefundResponse {
    private String APIConnect;
    private String bank_tran_id;
    private String trans_id;
    private String refund_ref_id;
    private String status;
    private String errorReason;
}