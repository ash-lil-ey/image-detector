package com.hackathon.image_detector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

    



    @RestController
    public class GeminiController{

        public void speak(String text) {
            try {
                String command = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; " +
                        "$speak = New-Object System.Speech.Synthesis.SpeechSynthesizer; " +
                        "$speak.Speak('" + text + "');\"";
                Runtime.getRuntime().exec(command);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static final String apiKey= "AIzaSyBSxyR1Mhxx4FYSUKJoGglQSOWLJxIchOs";

        @GetMapping("/api/test-vision")
        public String runVisionTest(){
         

            try{
              System.out.println("GET request to /api/test-vision received!");


            Client client = Client.builder()
                .apiKey(apiKey)
                .build();

            String imagePath = "src/main/resources/test_image.jpg.webp";
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

            Content content = Content.fromParts(
                Part.fromBytes(imageBytes, "image/webp"),
                Part.fromText("What is in this image? Be concise.")
            );

            System.out.println("Sending request to Gemini...");

            GenerateContentResponse response = client.models.generateContent(
                "models/gemini-2.5-pro", 
                content,
                null 
            );

            String aiResponse = response.text();
            System.out.println("Gemini Response: " + aiResponse);
            speak(aiResponse);
        
            return aiResponse;
            

        } catch (Exception e) {
            System.out.println("!!! REQUEST FAILED !!!");
            e.printStackTrace();
            return "ERROR: " + e.getMessage(); 
        }
    }

    @PostMapping("/api/analyze")
    public String postMethodName(@RequestBody byte[] imageBytes) {

            //  try{
            //     String responseMessage = "SUCCESS: Received image of "+ imageBytes.length+ "bytes.";
            //     System.out.println("Sending test response: "+responseMessage);
            //     return responseMessage;
            //   }catch(Exception e){
            //     System.out.println("REQUEST FAILED");
            //     e.printStackTrace();
            //     return "Error: "+ e.getMessage();
            //   }
 
    
            
       

        try {

        System.out.println("Starting Gemini test with new SDK...");




        Client client = Client.builder().apiKey(apiKey).build();
     
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
        System.out.println("Gemini Response: " + aiResponse);
        Runtime.getRuntime().exec("say " + aiResponse);

        return aiResponse;
        }catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }

    }

}
