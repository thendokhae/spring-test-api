package com.thendokhae.springbootrest.springrestapi.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceResource {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/invoices")
    public List<InvoiceEntity> viewAllInvoices(){
        return invoiceRepository.findAll();
    }

    @GetMapping("/invoices/{invoiceId}")
    public InvoiceEntity viewInvoice(@PathVariable Long invoiceId){
        Optional<InvoiceEntity> invoice = invoiceRepository.findById(invoiceId);
        if(!invoice.isPresent()){
            throw  new InvoiceNotFoundException("Invoice with id : "+invoiceId+" does not exist!");
        }
        return invoice.get();
    }

    @PostMapping("/invoices")
    public InvoiceEntity addInvoice(@Valid @RequestBody InvoiceEntity invoiceEntity){
        InvoiceEntity invoice =  invoiceRepository.save(invoiceEntity);

        return invoice;
    }
}
