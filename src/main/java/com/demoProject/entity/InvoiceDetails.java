package com.demoProject.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
public class InvoiceDetails {

    @Id
    String invoiceNo;
    String buyerOrderNo;
    String buyerCompanyName;
    String buyerCompanyAddress;
    String buyerCompanyAddress2;
    String buyerCompanyAddress3;
    String buyerGstNo;
    String buyerStateName;
    String buyerCode;
    String despatchDocumentNo;
    String despatchThrough;
    String terms;
    String destination;
    String date;
    String deliveryNoteDate;
    String modeOfPayment;
    String deliveryNote;
    String supplierOrderNo;
    String otherRef;

}
