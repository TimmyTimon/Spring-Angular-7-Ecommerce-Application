package com.springendrytesting1.SpringEndryTest1.repository;

import com.springendrytesting1.SpringEndryTest1.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}

