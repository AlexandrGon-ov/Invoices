package com.alexandr.goncharov.invoicesweb.model;


import javax.persistence.*;


@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="invoice_id")
    private int invoiceId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="shipping_address")
    private String shipping_address;

    @Column(name="amount")
    private Double amount;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Invoices[invoiceId = %s, customerName = %s, shipping_address = %s, amount = %s]";
    }
}
