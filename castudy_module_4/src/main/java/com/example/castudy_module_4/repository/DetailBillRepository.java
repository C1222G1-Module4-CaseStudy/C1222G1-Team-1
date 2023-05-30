package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.DetailBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailBillRepository extends JpaRepository<DetailBill,Integer> {
    @Query(value = "select * from detail_bill where id_product = :id_product and id_bill = :id_bill", nativeQuery = true)
    DetailBill findByProductByBill(@Param("id_product") int idProduct, @Param("id_bill") int idBill);
}
