# Ai-Personal-Assistant

🔍 A Java-based AI assistant using Apache OpenNLP for NLP processing. Detects sentences, names, and locations from user input.  

---

## ⚒️ Tech Stack  

| Technology        | Description  |
|------------------|-------------|
| Java            | Core programming language |
| Apache OpenNLP  | Used for NLP tasks like tokenization, sentence detection, and entity recognition |
| Maven          | Dependency management |
| IntelliJ IDEA  | IDE used for development |
| Console-based UI | Text-based interaction with users |

---

## 📝 Features  

✔ **Sentence Detection** – Splits user input into meaningful sentences  
✔ **Named Entity Recognition (NER)** – Detects names (persons) and locations from input  
✔ **Interactive Chat Interface** – Engages in a conversation with users  
✔ **Exit Command** – User can type `"exit"` to terminate the assistant  

---

## 🚀 How to Run the Project  

### 1️⃣ Clone the Repository  
```bash
git clone https://github.com/yourusername/AI-Assistant-NLP.git
cd AI-Assistant-NLP
```

### 2️⃣ Install Dependencies  
Ensure you have **Java 17+** and **Apache OpenNLP** installed.  

**For Maven Users:**  
```bash
mvn clean install
```

### 3️⃣ Setup NLP Models  
Download and place NLP models inside `src/main/resources/models/`:  
- `en-token.bin`  
- `en-sent.bin`  
- `en-ner-person.bin`  
- `en-ner-location.bin`  

### 4️⃣ Run the Project  
Start the AI Assistant with:  
```bash
mvn exec:java -Dexec.mainClass="AIAssistant"
```

### 5️⃣ Test Features  
Try entering:  
```bash
Hello, I am John. I will visit Paris next Monday.
```
The assistant should detect:  
```
Name: John
Location: Paris
```

---

---

## 📌 Future Enhancements  

🚀 **Facial Emotion Recognition** – Add emotion detection using **DeepLearning4J & OpenCV**  
🤖 **Chatbot Integration** – Connect with **ChatGPT API** for advanced responses  
📅 **Task Scheduling** – Implement a feature to **schedule and manage tasks**  

---



