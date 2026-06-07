package com.example.Spring_AI.controller;

import com.example.Spring_AI.service.AudioService;
import com.example.Spring_AI.service.ChatService;
import com.example.Spring_AI.service.ImageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController
{
    @Autowired
    private ChatService chatservice;

    @GetMapping("/ask-ai")
    public String askAi(@RequestParam String prompt)
    {
        return chatservice.askAI(prompt);
    }

    @Autowired
    private AudioService audioService;

    @GetMapping("/generate-audio")
    public String generateAudio(@RequestParam String text)
    {
        return audioService.convertTextToSpeech(text);
    }

    @Autowired
    private ImageService imageService;

    @GetMapping("/generate-image")
    public String generateImage(@RequestParam String prompt)
    {
        return imageService.generateImage(prompt);
    }
}
