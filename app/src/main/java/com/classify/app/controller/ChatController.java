package com.classify.app.controller;


import com.classify.app.model.Message;
import com.classify.app.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping(path = "/add")
    public Message updateAdvertisement(@RequestParam long receId , @RequestParam long sendId){
        Message msg=new Message();
        msg.setReceiverId(receId);
        msg.setSenderId(sendId);
        msg.setDatetime(LocalDate.now());

        return chatService.addChat(msg);
    }


}
