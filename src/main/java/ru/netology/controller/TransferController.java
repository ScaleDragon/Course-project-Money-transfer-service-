package ru.netology.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.exceptions.InvalidTransactionExceptions;
import ru.netology.model.CardTransfer;
import ru.netology.model.Verification;
import ru.netology.response.TransferAndConfirmResponse;
import ru.netology.service.TransferService;

@RestController
public class TransferController {
    TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferAndConfirmResponse> transferMoneyCardToCard(@RequestBody @Validated CardTransfer cardTransfer) {
        try {
            String operationId = transferService.transferMoneyCardToCard(cardTransfer);
            return ResponseEntity.ok(new TransferAndConfirmResponse(operationId));
        } catch (InvalidTransactionExceptions e) {
            TransferAndConfirmResponse response = new TransferAndConfirmResponse();
            response.setOperationId("Ошибка: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<TransferAndConfirmResponse> confirmOperation(@RequestBody @Validated Verification verification) {
        try {
            String operationId = transferService.confirmOperation(verification);
            return ResponseEntity.ok(new TransferAndConfirmResponse(operationId));
        } catch (InvalidTransactionExceptions e) {
            TransferAndConfirmResponse response = new TransferAndConfirmResponse();
            response.setOperationId("Ошибка: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
