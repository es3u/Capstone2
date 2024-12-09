package com.example.capstone2.Repository;

import com.example.capstone2.Model.OrderParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPartsRepository extends JpaRepository<OrderParts, Integer> {

    OrderParts findOrderPartsById(Integer orderId);

    List<OrderParts> findOrderPartsByStatus(Boolean status);

}
