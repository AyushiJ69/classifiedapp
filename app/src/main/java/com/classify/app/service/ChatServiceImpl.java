package com.classify.app.service;

import com.classify.app.model.Message;
import com.classify.app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements  ChatService{
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message addChat(Message message) {
        return messageRepository.save(message);
    }
}
