package com.classify.app.service;

import com.classify.app.model.User;
import com.classify.app.repository.CheckBuyerSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckUserImpl implements CheckUser{

    @Autowired
    CheckBuyerSellerRepository checkBuyerSellerRepository;

    @Override
    public User checkBuyer(long userId) {
        return checkBuyerSellerRepository.getIfBuyer(userId);
    }

    @Override
    public User checkSeller(long userId) {
        return checkBuyerSellerRepository.getIfSeller(userId);
    }

    @Override
    public User checkAdmin(long userId) {
        return checkBuyerSellerRepository.getIfAdmin(userId);
    }
}
