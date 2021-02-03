package com.demoProject.service;

import com.demoProject.constants.InvoiceConstant;
import com.demoProject.entity.InvoiceDetails;
import com.demoProject.entity.ItemDetails;
import com.demoProject.repository.InvoiceRepository;
import com.demoProject.repository.ItemRepository;
import com.demoProject.request.InvoiceRequest;
import com.demoProject.response.InvoiceResponse;
import com.demoProject.utils.DemoProjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {
    private final ModelMapper modelMapper;
    private final InvoiceRepository invoiceRepository;
    private final ItemRepository itemRepository;

    public InvoiceResponse createInvoice(InvoiceRequest invoiceRequest){
        String invoiceNo = DemoProjectUtils.generateId(InvoiceConstant.Invoice_No_Prefix);

        InvoiceDetails invoiceDetails = new InvoiceDetails();
        ItemDetails itemDetails = new ItemDetails();
        //itemDetails.setId(1);
        //invoiceDetails.setItemDetails(itemDetails);
        invoiceDetails.setInvoiceNo(invoiceNo);
        invoiceDetails.setBuyerOrderNo(invoiceRequest.getBuyerOrderNo());
        invoiceDetails.setBuyerCompanyName(invoiceRequest.getBuyerCompanyName());
        invoiceDetails.setBuyerCompanyAddress(invoiceRequest.getBuyerCompanyAddress());
        invoiceDetails.setBuyerCompanyAddress2(invoiceRequest.getBuyerCompanyAddress2());
        invoiceDetails.setBuyerCompanyAddress3(invoiceRequest.getBuyerCompanyAddress3());
        invoiceDetails.setBuyerGstNo(invoiceRequest.getBuyerGstNo());
        invoiceDetails.setBuyerStateName(invoiceRequest.getBuyerStateName());
        invoiceDetails.setBuyerCode(invoiceRequest.getBuyerCode());
        invoiceDetails.setDespatchDocumentNo(invoiceRequest.getDespatchDocumentNo());
        invoiceDetails.setDespatchThrough(invoiceRequest.getDespatchThrough());
        invoiceDetails.setTerms(invoiceRequest.getTerms());
        invoiceDetails.setDestination(invoiceRequest.getDestination());
        invoiceDetails.setDate(invoiceRequest.getDate());
        invoiceDetails.setModeOfPayment(invoiceRequest.getModeOfPayment());
        invoiceDetails.setDeliveryNoteDate(invoiceRequest.getDeliveryNoteDate());
        invoiceDetails.setDeliveryNote(invoiceRequest.getDeliveryNote());
        invoiceDetails.setSupplierOrderNo(invoiceRequest.getSupplierOrderNo());
        invoiceDetails.setOtherRef(invoiceRequest.getOtherRef());
        itemDetails.setDescription(invoiceRequest.getDescription());
        itemDetails.setHsnsac(invoiceRequest.getHsnsac());
        itemDetails.setQuantity(invoiceRequest.getQuantity());
        itemDetails.setRate(invoiceRequest.getRate());
        itemDetails.setPer(invoiceRequest.getPer());
        InvoiceDetails invoice = invoiceRepository.save(invoiceDetails);
        try {

            itemDetails.setInvoiceDetails(invoiceDetails);
            ItemDetails item = itemRepository.save(itemDetails);
        } catch (NotReadablePropertyException e) {
            e.printStackTrace();
        }



        return modelMapper.map(invoice,InvoiceResponse.class);

    }

    public InvoiceResponse getInvoiceDetails(String invoiceNo) {
        InvoiceDetails invoiceDetails = invoiceRepository.findByInvoiceNo(invoiceNo);

        return modelMapper.map(invoiceDetails,InvoiceResponse.class);
    }
}
