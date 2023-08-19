package com.classify.app.controller;


import com.classify.app.model.Email;
import com.classify.app.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailRepository emailRepository;

    @GetMapping(path="/verify")
    public Email verifyEmail(@RequestParam Long userId , @RequestParam String otp){
        Optional<Email> email= emailRepository.findById(userId);
        if(email.isPresent() && email.get().getOtp().equalsIgnoreCase(otp)){
            return email.get();

        }
        return null;
    }

    @PostMapping(path="/otpSent")
    public Email updateOtp(@RequestBody Email email){

        return emailRepository.save(email);
    }
}
