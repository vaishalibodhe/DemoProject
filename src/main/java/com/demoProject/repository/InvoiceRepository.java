package com.demoProject.repository;

import com.demoProject.entity.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceDetails, String> {
    InvoiceDetails findByInvoiceNo(String invoiceNo);
}
