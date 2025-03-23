package com.taa.tshirtsatis.repository;

import com.taa.tshirtsatis.entity.Rewiew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewiewRepository extends JpaRepository<Rewiew, Integer> {
    public List<Rewiew> findAllByUserId(int userId);
    public List<Rewiew> findAllByProductId(int productId);




    //query yazılacak
    @Query(value = "SELECT r from rewiew r where rating=:rating",nativeQuery = true)
    public List<Rewiew> getAllRating(@Param("rating") float rating);

    @Query(value = "select r from rewiew r where " +
            "product_id=:productId and " +
            "rating=:rating",nativeQuery = true)
    public List<Rewiew> getAllProductandRating(@Param("productId") int productId,
                                               @Param("rating") float rating);
}
