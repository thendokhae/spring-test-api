package com.thendokhae.springbootrest.springrestapi.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItemEntity, Long> {
}
