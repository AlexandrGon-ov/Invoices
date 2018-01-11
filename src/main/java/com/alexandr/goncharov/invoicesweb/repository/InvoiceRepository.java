package com.alexandr.goncharov.invoicesweb.repository;

import com.alexandr.goncharov.invoicesweb.model.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
import java.util.Optional;


public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {


    List<Invoice> findAll();
    Optional<Invoice> findById(Long invoiceId);
    void deleteById(Long invoiceId);
    Invoice save(Invoice invoice);

}
