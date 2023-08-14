package com.classify.app.controller;

import com.classify.app.model.Advertisement;
import com.classify.app.service.AdvertisementService;
import com.classify.app.service.CheckUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    CheckUser checkUser;
    @Autowired
    AdvertisementService advertisementService;

    @PostMapping(path = "/add")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement , @RequestParam long userId){
        if(checkUser.checkSeller(userId)!=null)
        {
            return advertisementService.add(advertisement);
        }
        return null;
    }

    @PostMapping(path = "/update")
    public Advertisement updateAdvertisement(@RequestBody Advertisement advertisement , @RequestParam long userId){
        if(checkUser.checkSeller(userId)!=null)
        {
            return advertisementService.add(advertisement);
        }
        return null;
    }

    @DeleteMapping(path = "/delete/{advId}")
    public HttpStatus deleteAdvertisement(@PathVariable("advId") Long advId , @RequestParam long userId){
        if(checkUser.checkSeller(userId)!=null)
        {
            advertisementService.delete(advId);
        }
        return HttpStatus.ACCEPTED;
    }
}
