package com.demoProject.request;
import lombok.Data;

@Data
public class InvoiceRequest {

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
    String modeOfPayment;
    String deliveryNoteDate;
    String deliveryNote;
    String supplierOrderNo;
    String otherRef;
    String description;
    String hsnsac;
    String quantity;
    String rate;
    String per;
    String total;


}
