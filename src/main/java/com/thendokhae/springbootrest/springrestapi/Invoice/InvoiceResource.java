package com.thendokhae.springbootrest.springrestapi.Invoice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceResource {

    @GetMapping("/invoices")
    public List<InvoiceEntity> viewAllInvoices(){
        return new ArrayList<>();
    }

    @GetMapping("/invoices/{invoiceId}")
    public InvoiceEntity viewInvoice(@PathVariable Long invoiceId){
        return new InvoiceEntity();
    }

    @PostMapping("/invoices")
    public InvoiceEntity addInvoice(@Valid @RequestBody InvoiceEntity invoiceEntity){
        return invoiceEntity;
    }
}
