package com.ofsystem.Config.Braintree;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/tokenPayment")
    public ResponseEntity<ClientTokenFilter> getToken(){
        return ResponseEntity.ok(paymentService.getTokenPago());
    }

    @PostMapping("/checkout")
    public ResponseEntity<Result<Transaction>> checkout(@RequestBody PurchaseFilter purchaseFilter){
        Result<Transaction> result = paymentService.checkout(purchaseFilter);

        if (result.isSuccess()) {
            // El pago se realizó exitosamente
            Transaction transaction = result.getTarget();
            // Puedes realizar acciones adicionales o enviar una respuesta adecuada
            return ResponseEntity.ok(result);
        } else {
            // El pago falló
            // Puedes manejar el error según tus necesidades
            return ResponseEntity.badRequest().body(result);
        }
    }


}
