package com.classify.app.controller;


import com.classify.app.model.Advertisement;
import com.classify.app.model.User;
import com.classify.app.repository.AdvertisementRepository;
import com.classify.app.repository.CheckBuyerSellerRepository;
import com.classify.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    CheckBuyerSellerRepository checkBuyerSellerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdvertisementRepository advertisementRepository;


    @GetMapping(path = "/user")
    public User blockUser(@RequestParam Long userId,@RequestParam Long blockingId,@RequestParam String flag){
        if(checkBuyerSellerRepository.getIfAdmin(userId)!=null){
            Optional<User> user=userRepository.findById(blockingId);
            if(user.isPresent()){
                User userObj=user.get();
                userObj.setBlocked(((flag.equals("T"))?true:false));
                userRepository.save(userObj);
            }
        }
        return null;
    }

    @GetMapping(path="/advertisement")
    public Advertisement blockAdvertisement(@RequestParam Long userId,@RequestParam Long blockingId,@RequestParam String flag){
        if(checkBuyerSellerRepository.getIfAdmin(userId)!=null){
            Optional<Advertisement> advertisement=advertisementRepository.findById(blockingId);
            if(advertisement.isPresent()){
                Advertisement advertisementObj=advertisement.get();
                advertisementObj.setBlocked(((flag.equals("T"))?true:false));
                advertisementRepository.save(advertisementObj);
            }
        }
        return null;
    }

}
