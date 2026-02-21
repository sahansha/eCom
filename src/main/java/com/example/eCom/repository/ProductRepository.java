package com.example.eCom.repository;

import com.example.eCom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
List<Product> findByName(String name);
List<Product> findByPriceGreaterThan(double price);
List<Product> findByNameAndPrice(String name,double price);

@Query("select p from Product p where p.name=:name")
    List<Product> findByNameJPQL(@Param("name") String name);

    //Native Query
    //@Query(value="select * from product where name=:name", nativeQuery=true)
    @NativeQuery(value = "select * from product where name=:name")
    List<Product> findByNameNative(@Param("name") String name);

}
