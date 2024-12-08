package uk.ac.ncl.advancedjava.database;

// Importing the FixedResponseQuestion class from the 'pojo' package.
import uk.ac.ncl.advancedjava.pojo.FixedResponseQuestion;

import java.util.ArrayList;
import java.util.List;

public class FixedResponseQuestionSet {

    // Declaring a list that will hold FixedResponseQuestion objects.
    List<FixedResponseQuestion> fixedResponseQuestionList = new ArrayList<>();

    // Constructor: When an instance of this class is created, the fixedResponseQuestionList is populated
    // with predefined fixed response questions by calling the generateFixedResponseQuestionList method.
    public FixedResponseQuestionSet() {
        generateFixedResponseQuestionList();
    }

    // Method to generate a list of predefined fixed response questions.
    public void generateFixedResponseQuestionList() {

        // Creating a FixedResponseQuestion object with a question and its correct answer.
        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?" , "Python"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?" , "AWS"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?" , "80"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion3);

        FixedResponseQuestion fixedResponseQuestion4 = new FixedResponseQuestion(
                "Operating system by Microsoft?" , "Windows"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion4);

        FixedResponseQuestion fixedResponseQuestion5 = new FixedResponseQuestion(
                "Protocol for secure web communication?" , "HTTPS"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion5);

        FixedResponseQuestion fixedResponseQuestion6 = new FixedResponseQuestion(
                "Company that owns Android?" , "Google"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion6);

        FixedResponseQuestion fixedResponseQuestion7 = new FixedResponseQuestion(
                "Programming language developed by Sun Microsystems?" , "Java"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion7);

        FixedResponseQuestion fixedResponseQuestion8 = new FixedResponseQuestion(
                "Short form of Central Processing Unit?" , "CPU"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion8);

        FixedResponseQuestion fixedResponseQuestion9 = new FixedResponseQuestion(
                "Database management system by Oracle?" , "MYSQL"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion9);

        FixedResponseQuestion fixedResponseQuestion10 = new FixedResponseQuestion(
                "Protocol for email retrieval?" , "IMAP"
        );

        fixedResponseQuestionList.add(fixedResponseQuestion10);
    }

    // Getter method to retrieve the list of fixed response questions.
    // This method returns the complete list of FixedResponseQuestion objects.
    public List<FixedResponseQuestion> getFixedResponseQuestionList() {
        return fixedResponseQuestionList;
    }
}
