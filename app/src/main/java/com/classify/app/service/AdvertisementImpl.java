package com.classify.app.service;

import com.classify.app.repository.AdvertisementRepository;
import com.classify.app.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdvertisementImpl implements  AdvertisementService{

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> getByUserId(long userId) {
        return advertisementRepository.findByUserId(userId);
    }
}
