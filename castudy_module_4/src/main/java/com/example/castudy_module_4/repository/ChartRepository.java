package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.model.DetailBill;
import com.example.castudy_module_4.model.custom.IChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ChartRepository extends JpaRepository<DetailBill, Integer> {

//    @Query("select new com.example.castudy_module_4.model.custom.Chart(b.saleDate, SUM(db.total)) from Bill b join DetailBill db on b.id = db.bill.id group by b.saleDate")
//    List<Chart> reportBill();

    @Query(value = "select bill.sale_date as saleDate , sum(detail_bill.total) as revenue from bill join detail_bill on bill.id = detail_bill.id_bill group by sale_date", nativeQuery = true)
    List<IChart> reportBill();

    @Query(value = "select product.name_product as nameProduct , sum(detail_bill.quantity_order) as totals from product join detail_bill on product.id = detail_bill.id_product group by product.id limit 10", nativeQuery = true)
    List<IChart> reportSale();
}
