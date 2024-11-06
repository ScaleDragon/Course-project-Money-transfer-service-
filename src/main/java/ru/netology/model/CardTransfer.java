package ru.netology.model;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CardTransfer {
    @NotBlank(message = "Card number cannot be empty")
    @Pattern(regexp = "\\d{4} \\d{4} \\d{4} \\d{4}", message = "Card number must be in the format 0000 0000 0000 0000")
    private String cardFromNumber;

    @NotBlank(message = "Destination card number cannot be empty")
    @Pattern(regexp = "\\d{4} \\d{4} \\d{4} \\d{4}", message = "Card number must be in the format 0000 0000 0000 0000")
    private String cardToNumber;

    @NotBlank(message = "Expiration date is required")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/(\\d{2})$", message = "Expiration date must be in the format MM/YY")
    private String cardFromValidTill;

    @NotBlank(message = "CVC is required")
    @Size(min = 3, max = 3, message = "CVC must be exactly 3 digits")
    private String cardFromCVV;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Amount amount;


    public CardTransfer(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public CardTransfer() {
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
