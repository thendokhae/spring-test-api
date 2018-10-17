package com.thendokhae.springbootrest.springrestapi.Invoice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String Client;

    private Long vatRate;

    private Date invoiceDate;

    @OneToMany(mappedBy = "invoice")
    private List<LineItemEntity> lineItemList;

    public InvoiceEntity() {
    }

    public BigDecimal getSubTotal(){
        BigDecimal subTotal = BigDecimal.ZERO;
        for (LineItemEntity itemEntity: lineItemList) {
            subTotal = subTotal.add(itemEntity.getLineItemTotal());
        }
        return  subTotal.setScale(2, RoundingMode.HALF_UP);
    }

    public  BigDecimal getVat(){
        BigDecimal vatPercentage = BigDecimal.valueOf(vatRate).divide(BigDecimal.valueOf(100));
        BigDecimal subTotalVat = getSubTotal().multiply(vatPercentage);

        return subTotalVat.setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal(){
        return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<LineItemEntity> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<LineItemEntity> lineItemList) {
        this.lineItemList = lineItemList;
    }
}
