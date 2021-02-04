package com.demoProject.controller;

import com.demoProject.entity.InvoiceDetails;
import com.demoProject.request.InvoiceRequest;
import com.demoProject.response.InvoiceResponse;
import com.demoProject.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/Invoice")
public class InvoiceController {
    private  final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@Valid @RequestBody InvoiceRequest invoiceRequest)
    {
        InvoiceResponse invoiceResponse = invoiceService.createInvoice(invoiceRequest);
        return ResponseEntity.ok(invoiceResponse);
    }

    @GetMapping("/{invoiceNo}")
    public ResponseEntity<InvoiceResponse> getInvoiceDetails(@Valid @PathVariable String invoiceNo){
        InvoiceResponse invoiceResponse = invoiceService.getInvoiceDetails(invoiceNo);
        return ResponseEntity.ok(invoiceResponse);
    }

}
