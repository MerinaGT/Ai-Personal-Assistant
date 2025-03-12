import java.io.IOException;
import java.util.Scanner;

public class AIAssistant {
    public static void main(String[] args) {
        try {
            NLPProcessor nlpProcessor = new NLPProcessor();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hello! I am your AI Assistant. How can I help you?");

            while (true) {
                System.out.print("You: ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }

                // Process sentences
                String[] sentences = nlpProcessor.detectSentences(userInput);
                System.out.println("Processed Sentences: " + String.join(" | ", sentences));

                // Detect person names
                String detectedNames = nlpProcessor.findPersonNames(userInput);
                System.out.println("Detected Names: " + detectedNames);

                // Detect locations
                String detectedLocations = nlpProcessor.findLocations(userInput);
                System.out.println("Detected Locations: " + detectedLocations);
            }

            scanner.close();
        } catch (IOException e) {
            System.err.println("Error initializing NLP Processor: " + e.getMessage());
        }
    }
}
