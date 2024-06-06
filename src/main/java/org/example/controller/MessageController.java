package org.example.controller;

import org.example.model.Message;
import org.example.service.MongoUserDetailsService;
import org.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MongoUserDetailsService userService;

    @GetMapping("/messages")
    public String getMessages(Model model) {
        String currentUsername = userService.getCurrentUser().getUsername();
        List<Message> messages = messageRepository.findByRecipient(currentUsername);
        model.addAttribute("messages", messages);
        return "messages";
    }

    @PostMapping("/messages")
    public String sendMessage(@RequestParam String recipient, @RequestParam String content) {
        String sender = userService.getCurrentUser().getUsername();
        Message message = new Message(sender, recipient, content);
        messageRepository.save(message);
        return "redirect:/messages";
    }
}
