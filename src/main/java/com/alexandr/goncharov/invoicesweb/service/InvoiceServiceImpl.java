package com.alexandr.goncharov.invoicesweb.service;

import com.alexandr.goncharov.invoicesweb.model.Invoice;
import com.alexandr.goncharov.invoicesweb.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InvoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceService invoiceService;


    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(int invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);

    }

    @Override
    public void deleteById(int invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }


}
