package org.sid.ebankbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

/**
 * @author EL Mehdi EL MAIS
 */
@Service
public class EbankAIAgent {
    private ChatClient chatClient;

    public EbankAIAgent(
            ChatClient.Builder chatClient,
            ChatMemory chatMemory,
            ToolCallbackProvider toolCallbackProvider
    ) {
        this.chatClient = chatClient
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(toolCallbackProvider)
                .build()
        ;
    }


    public String chat(String query){
        return chatClient
                .prompt()
                .user(query)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, "ebank-chatbot"))
                .call()
                .content();

    }
}
