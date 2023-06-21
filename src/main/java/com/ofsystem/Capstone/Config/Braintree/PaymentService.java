package com.ofsystem.Capstone.Config.Braintree;

import com.braintreegateway.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    BraintreeConfig config;

    public BraintreeGateway getGateway() {
        return new BraintreeGateway(
            Environment.SANDBOX,
                config.getMerchatId(),
                config.getPublicKey(),
                config.getPrivateKey()
        );
    };

    public ClientTokenFilter getTokenPago() {
        ClientTokenRequest request = new ClientTokenRequest();
        String token = getGateway().clientToken().generate(request);
        return new ClientTokenFilter(token);
    }

    public Result<Transaction> checkout (PurchaseFilter filter) {
        System.out.println(filter);
        TransactionRequest request = new TransactionRequest()
                .amount(filter.getAmount())
                .paymentMethodNonce(filter.getNonce())
                .options()
                .submitForSettlement(true)
                .done();
        return getGateway().transaction().sale(request);
    }
}
