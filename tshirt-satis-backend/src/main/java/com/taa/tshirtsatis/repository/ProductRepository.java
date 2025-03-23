package com.taa.tshirtsatis.repository;

import com.taa.tshirtsatis.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findById(int id);

    public boolean deleteById(int id);




//    @Query(value = "select p.* from product " +
//            "join products_categories pc on pc.product_id=p.id" +
//            "where pc.category_id=:categoryId"
//            ,nativeQuery = true)
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id=:categoryId")
    public List<Product> findByCategoryId(@Param("categoryId") int categoryId);

//    @Query(value = "select p.* from product " +
//            "join products_categories pc on pc.product_id=p.id" +
//            "join category c on c.id=pc.category_id" +
//            "where c.name=:categoryName"
//            ,nativeQuery = true)
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.name=:categoryName")
    public List<Product> findByCategoryName(@Param("categoryName") String categoryName);


}
