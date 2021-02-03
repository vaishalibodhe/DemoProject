package com.demoProject.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponse {

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
    String deliveryNoteDate;
    String date;
    String modeOfPayment;
    String deliveryNote;
    String supplierOrderNo;
    String otherRef;
}
