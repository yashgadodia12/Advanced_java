package uk.ac.ncl.advancedjava.tests;

import uk.ac.ncl.advancedjava.pojo.FixedResponseQuestion;
import uk.ac.ncl.advancedjava.pojo.Question;
import uk.ac.ncl.advancedjava.pojo.Student;
import uk.ac.ncl.advancedjava.system.Quiz;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystemFixedResponseTest {

    /**
     * Test case to check if the student fails in the first attempt.
     * The student answers 1 out of 3 questions correctly.
     */
    @Test
    public void test_AttemptOneFail() {
        Student student1 = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        // Add questions to the quiz
        List<Question> questions = new ArrayList<>();

        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?", "Python"
        );
        questions.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?", "AWS"
        );
        questions.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?", "80"
        );
        questions.add(fixedResponseQuestion3);

        // Incorrect answers for 2nd and 3rd questions
        List<String> answers = new ArrayList<>();
        answers.add("Python");
        answers.add("A");
        answers.add("60");
        quiz.takeQuiz(student1, questions, answers);

        System.out.println(quiz.generateStatistics(student1));

        // Assert that the student hasn't passed yet
        Assert.assertNull(student1.getFinalVerdict());
        Assert.assertEquals(0.3333333333333333, student1.getStudentStats().getAttemptScores()[0], 0);
    }

    /**
     * Test case to check if the student fails in two consecutive attempts.
     */
    @Test
    public void testAttemptOneFail_AttemptTwoFail() {
        Student student1 = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        List<Question> questions = new ArrayList<>();

        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?", "Python"
        );
        questions.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?", "AWS"
        );
        questions.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?", "80"
        );
        questions.add(fixedResponseQuestion3);


        List<String> answers = new ArrayList<>();
        answers.add("Python");
        answers.add("A");
        answers.add("60");
        quiz.takeQuiz(student1, questions, answers);

        quiz.takeQuiz(student1, questions, answers);

        System.out.println(quiz.generateStatistics(student1));

        // Assert that the student fails after 2 attempts
        Assert.assertEquals("FAIL", student1.getFinalVerdict());
        Assert.assertEquals(0.3333333333333333, student1.getStudentStats().getAttemptScores()[0], 0);
        Assert.assertEquals(0.3333333333333333, student1.getStudentStats().getAttemptScores()[1], 0);
    }

    /**
     * Test case to check if the student passes in the first attempt.
     */
    @Test
    public void test_AttemptOnePass() {
        Student student1 = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        List<Question> questions = new ArrayList<>();

        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?", "Python"
        );
        questions.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?", "AWS"
        );
        questions.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?", "80"
        );
        questions.add(fixedResponseQuestion3);


        List<String> answers = new ArrayList<>();
        answers.add("Python");
        answers.add("AWS");
        answers.add("60");
        quiz.takeQuiz(student1, questions, answers);

        System.out.println(quiz.generateStatistics(student1));

        // Assert that the student passes on the first attempt
        Assert.assertEquals("PASS", student1.getFinalVerdict());
        Assert.assertEquals(0.6666666666666666, student1.getStudentStats().getAttemptScores()[0], 0);
    }

    /**
     * Test case to check if a second attempt is ignored after the student passes in the first attempt.
     */
    @Test
    public void test_AttemptOnePass_AttemptTwoInvalid() {
        Student student1 = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        List<Question> questions = new ArrayList<>();

        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?", "Python"
        );
        questions.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?", "AWS"
        );
        questions.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?", "80"
        );
        questions.add(fixedResponseQuestion3);


        List<String> answers = new ArrayList<>();
        answers.add("Python");
        answers.add("AWS");
        answers.add("60");
        quiz.takeQuiz(student1, questions, answers);

        System.out.println(quiz.generateStatistics(student1));

        Assert.assertEquals("PASS", student1.getFinalVerdict());
        Assert.assertEquals(0.6666666666666666, student1.getStudentStats().getAttemptScores()[0], 0);

        List<String> answers1 = new ArrayList<>();
        answers.add("Python");
        answers.add("AWS");
        answers.add("80");
        quiz.takeQuiz(student1, questions, answers1);

        // Assert that the student's final verdict doesn't change
        Assert.assertEquals("PASS", student1.getFinalVerdict());
        Assert.assertEquals(0.6666666666666666, student1.getStudentStats().getAttemptScores()[0], 0);
        Assert.assertEquals(0.0, student1.getStudentStats().getAttemptScores()[1], 0);

    }

    /**
     * Test case to check if extra spaces and case differences in answers are handled correctly.
     */
    @Test
    public void test_ExtraSpacesAndIgnoreCase() {
        Student student1 = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        List<Question> questions = new ArrayList<>();
        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?" , "Python PySpark"
        );
        questions.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?" , "AWS"
        );
        questions.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?" , "80"
        );
        questions.add(fixedResponseQuestion3);


        List<String> answers = new ArrayList<>();
        answers.add("Python   PYsPARk    ");
        answers.add("A");
        answers.add("60");
        quiz.takeQuiz(student1, questions, answers);

        Assert.assertEquals(null, student1.getFinalVerdict());
        Assert.assertEquals(0.3333333333333333, student1.getStudentStats().getAttemptScores()[0], 0);
        Assert.assertEquals(0.0, student1.getStudentStats().getAttemptScores()[1], 0);

        answers = new ArrayList<>();
        answers.add("Python pYspark");
        answers.add("AWS");
        answers.add("60");
        quiz.takeQuiz(student1, questions, answers);

        // Assert student passes after the correct answers are normalized
        Assert.assertEquals("PASS", student1.getFinalVerdict());
        Assert.assertEquals(0.3333333333333333, student1.getStudentStats().getAttemptScores()[0], 0);
        Assert.assertEquals(0.6666666666666666, student1.getStudentStats().getAttemptScores()[1], 0);

    }

}
