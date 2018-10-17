package com.thendokhae.springbootrest.springrestapi.Invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "LineItem")
public class LineItemEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long quantity;

    private BigDecimal unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private InvoiceEntity invoice;

    public LineItemEntity() {
    }

    public BigDecimal getLineItemTotal(){
        BigDecimal lineTotal =  unitPrice.multiply(BigDecimal.valueOf(quantity));
        return lineTotal.setScale(2, RoundingMode.HALF_UP);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }
}
