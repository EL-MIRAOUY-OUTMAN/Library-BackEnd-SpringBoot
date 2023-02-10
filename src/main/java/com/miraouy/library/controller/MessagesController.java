package com.miraouy.library.controller;
import com.miraouy.library.Dtos.AdminQuestionRequest;

import com.miraouy.library.entity.Message;
import com.miraouy.library.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestBody String userEmail,
                            @RequestBody Message messageRequest) {
        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestBody String admin,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {

        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only.");
        }
        messagesService.putMessage(adminQuestionRequest, admin);
    }

}














