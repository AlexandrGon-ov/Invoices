package com.alexandr.goncharov.invoicesweb.repository;

import com.alexandr.goncharov.invoicesweb.model.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer> {

    List<Invoice> findAll();
    Invoice findById(int invoiceId);
    void deleteById(int invoiceId);

}
