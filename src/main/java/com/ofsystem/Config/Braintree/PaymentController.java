package com.ofsystem.Config.Braintree;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/tokenPayment")
    public ResponseEntity<ClientTokenFilter> getToken(){
        return ResponseEntity.ok(paymentService.getTokenPago());
    }

    @PostMapping("/checkout")
    public ResponseEntity<Result<Transaction>> checkout(@RequestBody PurchaseFilter purchaseFilter){
        return ResponseEntity.ok(paymentService.checkout(purchaseFilter));
    }


}
