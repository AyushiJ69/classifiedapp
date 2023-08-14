package com.classify.app.service;

import com.classify.app.repository.AdvertisementRepository;
import com.classify.app.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementImpl implements  AdvertisementService{

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> getByUserId(long userId) {
        return advertisementRepository.findByUserId(userId);
    }

    @Override
    public Advertisement add(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public void delete(long advId) {
        advertisementRepository.deleteById(advId);
    }
}
