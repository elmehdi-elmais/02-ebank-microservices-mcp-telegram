package org.sid.ebankbot.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sid.ebankbot.agents.EbankAIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EL Mehdi EL MAIS
 */
@RestController
@RequiredArgsConstructor
public class EbankChatbotController {
    private final EbankAIAgent ebankAIAgent;


    @GetMapping("/chat")
    public String chat(@RequestParam(name="query", defaultValue = "Bonjour") String query){
        return ebankAIAgent.chat(query);

    }
}
