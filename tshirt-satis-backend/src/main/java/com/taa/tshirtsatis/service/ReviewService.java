package com.taa.tshirtsatis.service;

import com.taa.tshirtsatis.entity.Rewiew;
import com.taa.tshirtsatis.repository.RewiewRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final RewiewRepository reviewRepository;

    public ReviewService(RewiewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public List<Rewiew> findAllByUserId(int userId){
        return reviewRepository.findAllByUserId(userId);
    }
    public List<Rewiew> findAllByProductId(int productId){
        return reviewRepository.findAllByProductId(productId);
    }

    public List<Rewiew> getAllRating(float rating){
        return reviewRepository.getAllRating(rating);
    }

    public List<Rewiew> getAllProductandRatingint(int productId,int rating){
        return reviewRepository.getAllProductandRating(productId,rating);
    }

}

