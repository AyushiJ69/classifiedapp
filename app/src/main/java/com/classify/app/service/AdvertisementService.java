package com.classify.app.service;

import com.classify.app.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    public List<Advertisement> getByUserId(long userId);
}
