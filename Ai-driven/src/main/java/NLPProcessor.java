import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class NLPProcessor {
    private SentenceDetectorME sentenceDetector;
    private NameFinderME nameFinderPerson;
    private NameFinderME nameFinderLocation;

    public NLPProcessor() throws IOException {
        // Load Sentence Model
        InputStream sentenceModelIn = getClass().getClassLoader().getResourceAsStream("models/en-sent.bin");
        if (sentenceModelIn == null) {
            throw new IOException("Sentence model file not found! Ensure it's in src/main/resources/models/");
        }
        SentenceModel sentenceModel = new SentenceModel(sentenceModelIn);
        sentenceDetector = new SentenceDetectorME(sentenceModel);

        // Load Person Name Finder Model
        InputStream nameModelInPerson = getClass().getClassLoader().getResourceAsStream("models/en-ner-person.bin");
        if (nameModelInPerson == null) {
            throw new IOException("Person NER model not found! Ensure it's in src/main/resources/models/");
        }
        TokenNameFinderModel nameModelPerson = new TokenNameFinderModel(nameModelInPerson);
        nameFinderPerson = new NameFinderME(nameModelPerson);

        // Load Location Name Finder Model
        InputStream nameModelInLocation = getClass().getClassLoader().getResourceAsStream("models/en-ner-location.bin");
        if (nameModelInLocation == null) {
            throw new IOException("Location NER model not found! Ensure it's in src/main/resources/models/");
        }
        TokenNameFinderModel nameModelLocation = new TokenNameFinderModel(nameModelInLocation);
        nameFinderLocation = new NameFinderME(nameModelLocation);
    }

    public String[] detectSentences(String text) {
        return sentenceDetector.sentDetect(text);
    }

    public String findEntities(String text, NameFinderME nameFinder) {
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(text);

        // Debugging Output
        System.out.println("Tokens: " + Arrays.toString(tokens));

        Span[] spans = nameFinder.find(tokens);
        StringBuilder result = new StringBuilder();

        for (Span span : spans) {
            result.append(tokens[span.getStart()]).append(" ");
        }

        return result.length() > 0 ? result.toString().trim() : "No entities detected.";
    }

    public String findPersonNames(String text) {
        return findEntities(text, nameFinderPerson);
    }

    public String findLocations(String text) {
        return findEntities(text, nameFinderLocation);
    }
}
