# ChatGPT-like Application with Spring Boot and Rasa

A chatbot application built using Spring Boot for the backend REST API and Rasa for natural language processing.

## Technology Stack

- Spring Boot (REST API backend)
- Rasa (Open-source chatbot framework)
- Maven (Build tool)
- Git (Version control)
- HTML/JavaScript (Simple frontend)

## Prerequisites

- Java 11+
- Maven
- Python 3.7+
- Git

## Project Structure

- `src/main/java/com/chatbot/api`: Spring Boot application code
- `rasa/`: Rasa chatbot code and configuration
- `src/main/resources/static/`: Frontend HTML/JS

## Git Setup and Push Instructions

### 1. Initialize a Git Repository (if not already done)

```bash
# Navigate to your project folder
cd chatbot-spring-rasa

# Initialize Git repository
git init

# Add all files to staging
git add .

# Commit your changes
git commit -m "Initial commit of chatbot application"
```

### 2. Push to a Remote Repository (GitHub, GitLab, etc.)

```bash
# Create a new repository on GitHub/GitLab first, then:

# Add the remote repository URL
git remote add origin https://github.com/your-username/chatbot-spring-rasa.git

# Push your code to the remote repository
git push -u origin main
# Note: Use 'master' instead of 'main' if you're using an older Git version
```

## Installation and Setup Instructions

### 1. Clone the Repository (for new installs)

```bash
git clone https://github.com/your-username/chatbot-spring-rasa.git
cd chatbot-spring-rasa
```

### 2. Set up the Spring Boot Application

```bash
# Build the project using Maven
mvn clean install
```

### 3. Set up the Rasa Chatbot

```bash
# Navigate to the Rasa directory
cd rasa

# Create a Python virtual environment
python -m venv venv

# Activate the virtual environment
# For Windows:
.\venv\Scripts\activate
# For macOS/Linux:
source venv/bin/activate

# Install Rasa and dependencies
pip install -r requirements.txt
# If requirements.txt is missing or empty, run:
pip install rasa==3.5.8

# Train the initial Rasa model
rasa train
```

## Running the Application

### 1. Start the Rasa Server

```bash
# Navigate to the Rasa directory (if not already there)
cd rasa

# Activate the virtual environment (if not already activated)
# For Windows:
.\venv\Scripts\activate
# For macOS/Linux:
source venv/bin/activate

# Start the Rasa server with API enabled
rasa run --enable-api --cors "*"
```

### 2. Start the Spring Boot Application

Open a new terminal window and navigate to the project root:

```bash
# From the project root directory
mvn spring-boot:run
```

### 3. Access the Chatbot

Open a web browser and navigate to:

```
http://localhost:8080
```

## Sample Chatbot Interactions

- "Hello" → "Hello! I'm your AI assistant. How can I help you today?"
- "What can you do?" → "I can answer questions, provide information, and help with various tasks. Feel free to ask me anything!"
- "Are you a bot?" → "I am an AI assistant powered by Rasa and Spring Boot. I'm here to help you."
- "I need help" → "You can ask me questions, and I'll do my best to help. What would you like to know about?"
- "Goodbye" → "Goodbye! Have a great day!"

## Troubleshooting

### Rasa Server Issues

1. Make sure the Rasa server is running on port 5005
2. Check if the API is enabled with the `--enable-api` flag
3. Ensure CORS is properly configured with `--cors "*"`
4. If responses are not as expected, retrain the model with `rasa train`

### Spring Boot Issues

1. Verify the application is running on port 8080
2. Check application.properties to ensure `rasa.url=http://localhost:5005`
3. Look for error messages in the console log

### Connection Issues

1. Ensure both servers are running simultaneously
2. Verify the Rasa endpoint is correctly configured in the Spring Boot service

## Customizing the Chatbot

1. Edit `rasa/data/nlu.yml` to modify training examples
2. Edit `rasa/domain.yml` to change bot responses
3. Retrain the model with `rasa train` after making changes
4. Restart the Rasa server to apply changes
