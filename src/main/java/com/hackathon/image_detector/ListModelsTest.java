// package com.hackathon.image_detector;



// public class ListModelsTest {

//     public static void main(String[] args) {

//     String apiKey ="AIzaSyBSxyR1Mhxx4FYSUKJoGglQSOWLJxIchOs";

//     try {
//             System.out.println("Connecting to Google AI to list available models...");

//            // Create the new Client
//             Client client = Client.builder()
//                 .apiKey(apiKey)
//                 .build();


//             // 2. Call the listModels() method
//             ListModelsResponse response = client.models().listModels();
//             System.out.println("--- Your Account Has Access to These Models ---");
            
//             // 3. Loop through the results
//             for (Model model : response.getModelsList()) {
//                 System.out.println(model.getName()); 
//             }
//             System.out.println("------------------------------------------------");
//             System.out.println("Find the model with 'vision' in the name and use it in GeminiTest.java");

//         } catch (Exception e) {
//             System.out.println("!!! TEST FAILED !!!");
//             e.printStackTrace();
//         }
//     }
// }