package uk.ac.ncl.advancedjava.tests;

import uk.ac.ncl.advancedjava.pojo.MultipleChoiceQuestion;
import uk.ac.ncl.advancedjava.pojo.Question;
import uk.ac.ncl.advancedjava.pojo.Student;
import uk.ac.ncl.advancedjava.system.Quiz;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystemMultipleChoiceTest {

    /**
     * Test case to check if the student passes the quiz on the first attempt.
     * The student answers all questions correctly.
     */
    @Test
    public void test_AttempOnePass() {

        Student student1 = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        List<Question> questions = new ArrayList<>();

        // Adding a multiple-choice question about programming languages
        MultipleChoiceQuestion multipleChoiceQuestion1 = new MultipleChoiceQuestion(
                "Which of the following are programming languages?" ,
                "Python", "HTML", "JavaScript", "Photoshop", "Python,HTML,JavaScript"
        );
        questions.add(multipleChoiceQuestion1);

        // Adding a multiple-choice question about cloud computing platforms
        MultipleChoiceQuestion multipleChoiceQuestion2 = new MultipleChoiceQuestion(
                "Which are types of databases?" ,
                "MySQL", "Oracle", "PostgreSQL", "HTTP", "MySQL,Oracle,PostgreSQL"
        );
        questions.add(multipleChoiceQuestion2);

        // Adding a multiple-choice question about cloud computing platforms
        MultipleChoiceQuestion multipleChoiceQuestion3 = new MultipleChoiceQuestion(
                "Which of these are cloud computing platforms?" ,
                "AWS", "Azure", "Google Cloud", "GitHub", "AWS,Azure,Google Cloud"
        );
        questions.add(multipleChoiceQuestion3);

        // List of correct answers provided by the student
        List<String> answers = new ArrayList<>();
        answers.add("HTML,JavaScript,Python"); // Correct answers for programming languages
        answers.add("MySQL,Oracle,PostgreSQL"); // Correct answers for databases
        answers.add("Azure,AWS,Google Cloud"); // Correct answers for cloud platforms

        // Student takes the quiz with the provided answers
        quiz.takeQuiz(student1, questions, answers);

        // Output statistics for debugging purposes
        System.out.println(quiz.generateStatistics(student1));

        // Verify that the student passes the quiz
        Assert.assertEquals("PASS", student1.getFinalVerdict());
        Assert.assertEquals(1, student1.getStudentStats().getAttemptScores()[0], 0);

    }

}
