package com.alexandr.goncharov.invoicesweb.service;

import com.alexandr.goncharov.invoicesweb.model.Invoice;

import java.util.List;


public interface InvoiceService {

    List<Invoice> findAll();
    Invoice findById(Long invoiceId);
    Invoice save(Invoice invoice);
    void deleteById(Long invoiceId);
    List<Invoice> findByCustomerName(String customerName);
}
