package com.demoProject.repository;

import com.demoProject.entity.InvoiceDetails;
import com.demoProject.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<InvoiceDetails, Integer> {
    ItemDetails save(ItemDetails itemDetails);
}
