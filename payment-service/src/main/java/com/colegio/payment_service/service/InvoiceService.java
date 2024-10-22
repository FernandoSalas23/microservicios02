package com.colegio.payment_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.payment_service.entity.Invoice;
import com.colegio.payment_service.repository.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice generateInvoice(Invoice invoice) {
        invoice.setInvoiceNumber(UUID.randomUUID().toString());
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoicesByStudent(String studentName) {
        return invoiceRepository.findByStudentName(studentName);
    }

    public Invoice updateInvoiceStatus(Long id, String status) {
        Invoice invoice = invoiceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Boleta no encontrada"));
        invoice.setStatus(status);
        return invoiceRepository.save(invoice);
    }
    
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

}
