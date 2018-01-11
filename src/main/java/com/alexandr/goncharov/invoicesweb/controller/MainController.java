package com.alexandr.goncharov.invoicesweb.controller;

import com.alexandr.goncharov.invoicesweb.model.Invoice;
import com.alexandr.goncharov.invoicesweb.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;


@RestController
@RequestMapping("/")
public class MainController {


    @Autowired
    private InvoiceService invoiceService;


    @GetMapping("invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        List<Invoice> list = invoiceService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("invoice")
    public ResponseEntity<Void> createInvoice(@RequestBody Invoice invoice, UriComponentsBuilder uriComponentsBuilder ){

        invoiceService.save(invoice);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("invoice/{id}").buildAndExpand(invoice.getInvoiceId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("invoice/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id){
        Invoice invoice = invoiceService.findById(id);
        invoiceService.save(invoice);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }


    @GetMapping("invoiceCustom/{customerName}")
    public ResponseEntity getInvoiceByCustomerName(@PathVariable("customerName") String customerName) {
        List<Invoice> invoice;
        invoice = invoiceService.findByCustomerName(customerName);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }



    @DeleteMapping("invoice/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") Long id){
        invoiceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
