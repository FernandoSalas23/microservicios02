package com.colegio.payment_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.colegio.payment_service.entity.Invoice;
import com.colegio.payment_service.service.InvoiceService;
import com.colegio.payment_service.service.MessagePublisherService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private MessagePublisherService messagePublisherService;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.generateInvoice(invoice);
        String notificationMessage = "Se ha registrado una nueva boleta con número: " + savedInvoice.getInvoiceNumber();
        messagePublisherService.sendPaymentNotification(notificationMessage);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInvoice);
    }

    @GetMapping("/student/{studentName}")
    public ResponseEntity<List<Invoice>> getInvoicesByStudent(@PathVariable String studentName) {
        List<Invoice> invoices = invoiceService.getInvoicesByStudent(studentName);
        return ResponseEntity.ok(invoices);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoiceStatus(@PathVariable Long id, @RequestBody String status) {
        Invoice updatedInvoice = invoiceService.updateInvoiceStatus(id, status);
        return ResponseEntity.ok(updatedInvoice);
    }
    
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

}
