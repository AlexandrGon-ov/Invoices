package com.alexandr.goncharov.invoicesweb.service;

import com.alexandr.goncharov.invoicesweb.model.Invoice;

import java.util.List;


public interface InvoiceService {

    List<Invoice> findAll();
    Invoice findById(int invoiceId);
    void saveInvoice(Invoice invoice);
    void deleteById(int invoiceId);
}
