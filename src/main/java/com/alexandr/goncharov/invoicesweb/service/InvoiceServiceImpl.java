package com.alexandr.goncharov.invoicesweb.service;

import com.alexandr.goncharov.invoicesweb.model.Invoice;
import com.alexandr.goncharov.invoicesweb.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service("InvoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceService invoiceService;


    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }


    public List<Invoice> findByCustomerName(String customerName){
        String queryForQuery = "FROM Invoice where customer_name like " + "'%" + customerName + "%'" ;
        Query query1 =  entityManager.createQuery(queryForQuery);
        return (List<Invoice>) query1.getResultList();
    }

    @Override
    public Invoice save(Invoice invoice) {
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public void deleteById(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }


}
