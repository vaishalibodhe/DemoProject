package com.demoProject.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class ItemDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String description;
    String hsnsac;
    String quantity;
    String rate;
    String per;
    String total;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoiceNo")
    InvoiceDetails invoiceDetails;
}
