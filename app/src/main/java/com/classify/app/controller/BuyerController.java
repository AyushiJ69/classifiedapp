package com.classify.app.controller;


import com.classify.app.model.Advertisement;
import com.classify.app.repository.AdvertisementRepository;
import com.classify.app.repository.CheckBuyerSellerRepository;
import com.classify.app.service.AdvertisementService;
import com.classify.app.service.CheckUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    CheckUser checkUser;
    @Autowired
    AdvertisementService advertisementService;

    @GetMapping(path = "/search/{name}")
    public List<Advertisement> searchByProductName(@PathVariable String name , @RequestParam long userId){
        if(checkUser.checkBuyer(userId)!=null)
        {
            List<Advertisement> adv =  advertisementService.getByUserId(userId);
            return adv.stream().filter(advertisement -> advertisement.getTitle().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        return null;
    }

    @GetMapping(path = "/category/{category}")
    public List<Advertisement> searchByCategory(@PathVariable String category , @RequestParam long userId){
        if(checkUser.checkBuyer(userId)!=null)
        {
            List<Advertisement> adv =  advertisementService.getByUserId(userId);
            return adv.stream().filter(advertisement -> advertisement.getCategory().getName().equalsIgnoreCase(category)).collect(Collectors.toList());
        }
        return null;
    }
    @GetMapping(path = "/location/{location}")
    public List<Advertisement> searchByLocation(@PathVariable String location , @RequestParam long userId){
        if(checkUser.checkBuyer(userId)!=null)
        {
            List<Advertisement> adv =  advertisementService.getByUserId(userId);
            return adv.stream().filter(advertisement -> advertisement.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
        }
        return null;
    }

}
