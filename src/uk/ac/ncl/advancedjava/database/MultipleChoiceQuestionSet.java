package uk.ac.ncl.advancedjava.database;

// Importing the MultipleChoiceQuestion class from the 'pojo' package.
import uk.ac.ncl.advancedjava.pojo.MultipleChoiceQuestion;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestionSet {

    // Declaring a list to hold MultipleChoiceQuestion objects.
    List<MultipleChoiceQuestion> multipleChoiceQuestionList = new ArrayList<>();

    // Constructor: When an instance of this class is created, it automatically populates
    // the list with predefined multiple-choice questions by calling the generateFixedResponseQuestionList method.
    public MultipleChoiceQuestionSet() {
        generateFixedResponseQuestionList();
    }
    // Method to generate a list of predefined multiple-choice questions.
    public void generateFixedResponseQuestionList() {

        // Creating a MultipleChoiceQuestion object with a question, options, and the correct answers.
        MultipleChoiceQuestion multipleChoiceQuestion1 = new MultipleChoiceQuestion(
                "Which of the following are programming languages?" ,
                "Python", "HTML", "JavaScript", "Photoshop", "Python,HTML,JavaScript"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion1);

        MultipleChoiceQuestion multipleChoiceQuestion2 = new MultipleChoiceQuestion(
                "Which are types of databases?" ,
                "MySQL", "Oracle", "PostgreSQL", "HTTP", "MySQL,Oracle,PostgreSQL"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion2);

        MultipleChoiceQuestion multipleChoiceQuestion3 = new MultipleChoiceQuestion(
                "Which of these are cloud computing platforms?" ,
                "AWS", "Azure", "Google Cloud", "GitHub", "AWS,Azure,Google Cloud"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion3);

        MultipleChoiceQuestion multipleChoiceQuestion4 = new MultipleChoiceQuestion(
                "Which of these are types of networks?" ,
                "LAN", "WAN", "CPU", "d", "LAN,WAN,PAN"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion4);

        MultipleChoiceQuestion multipleChoiceQuestion5 = new MultipleChoiceQuestion(
                "Which are operating systems?" ,
                "Windows", "Linux", "iOS", "BIOS", "Windows,Linux,iOS"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion5);

        MultipleChoiceQuestion multipleChoiceQuestion6 = new MultipleChoiceQuestion(
                "Which are markup languages?" ,
                "HTML", "XML", "CSS", "JSON", "HTML,XML,JSON"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion6);

        MultipleChoiceQuestion multipleChoiceQuestion7 = new MultipleChoiceQuestion(
                "Which are relational database management systems (RDBMS)?" ,
                "Oracle", "MongoDB", "MySQL", "PostgreSQL", "Oracle,MySQL,PostgreSQL"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion7);

        MultipleChoiceQuestion multipleChoiceQuestion8 = new MultipleChoiceQuestion(
                "Which of these are programming paradigms?" ,
                "Object-Oriented", "Functional", "Relational", "Procedural", "Object-Oriented,Functional,Procedural"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion8);

        MultipleChoiceQuestion multipleChoiceQuestion9 = new MultipleChoiceQuestion(
                "Which protocols are used for email communication?" ,
                "IMAP", "SMTP", "FTP", "POP3", "IMAP,SMTP,POP3"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion9);

        MultipleChoiceQuestion multipleChoiceQuestion10 = new MultipleChoiceQuestion(
                "Which are valid file extensions for an image?" ,
                ".jpg", ".png", ".exe", ".gif", ".jpg,.png,.gif"
        );

        multipleChoiceQuestionList.add(multipleChoiceQuestion10);
    }

    // Getter method to retrieve the list of multiple-choice questions.
    // This method returns the complete list of MultipleChoiceQuestion objects.
    public List<MultipleChoiceQuestion> getMultipleChoiceQuestionList() {
        return multipleChoiceQuestionList;
    }

}
