package com.thendokhae.springbootrest.springrestapi.Invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class InvoiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String Client;

    private Long vatRate;

    private Date invoiceDate;

    @OneToMany(mappedBy = "invoiceEntity")
    private List<LineItemEntity> lineItemList;

    public InvoiceEntity() {
    }

    public BigDecimal getSubTotal(){
        return  BigDecimal.ZERO;
    }

    public  BigDecimal getVat(){
        return BigDecimal.ZERO;
    }

    public BigDecimal getTotal(){
        return BigDecimal.ZERO;
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
}
