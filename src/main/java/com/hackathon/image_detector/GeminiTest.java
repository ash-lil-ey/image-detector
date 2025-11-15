package com.hackathon.image_detector;

import com.google.genai.types.GenerateContentResponse;
import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import java.io.File;



import java.nio.file.Files;
import java.nio.file.Paths;


public class GeminiTest {
    
    public static void main(String[] args){
        String apiKey= "AIzaSyBSxyR1Mhxx4FYSUKJoGglQSOWLJxIchOs";

        try{
            System.out.println("Starting Gemini test with new SDK...");

            Client client = Client.builder()
                .apiKey(apiKey)
                .build();

             String imagePath = "src/main/resources/test_image.jpg.webp";

            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

             Content content = Content.fromParts(
                // This is the correct method: Part.fromBytes(...)
                Part.fromBytes(imageBytes, "image/webp"),
                Part.fromText("What is in this image? Be concise.")
            );

          

            System.out.println("Sending request to Gemini... (This may take a moment)");

            GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-pro", 
                content,
                null 
            );

            String aiResponse = response.text();
            System.out.println("--- Gemini's Response ---");
            System.out.println(aiResponse);
            System.out.println("--------------------------");

            } catch (Exception e) {
            System.out.println("!!! TEST FAILED !!!");
            e.printStackTrace();
        }
    }
}

