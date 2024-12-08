import uk.ac.ncl.advancedjava.system.Quiz;
import uk.ac.ncl.advancedjava.pojo.FixedResponseQuestion;
import uk.ac.ncl.advancedjava.pojo.Question;
import uk.ac.ncl.advancedjava.pojo.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s = new Student("A", "B", new Date());

        Quiz quiz = new Quiz();

        //List<Question> qs = quiz.generateQuiz(2);

        List<Question> qs = new ArrayList<>();
        FixedResponseQuestion fixedResponseQuestion1 = new FixedResponseQuestion(
                "Programming language starting with 'P'?" , "Python Java"
        );

        qs.add(fixedResponseQuestion1);

        FixedResponseQuestion fixedResponseQuestion2 = new FixedResponseQuestion(
                "Cloud service by Amazon?" , "AWS"
        );

        qs.add(fixedResponseQuestion2);

        FixedResponseQuestion fixedResponseQuestion3 = new FixedResponseQuestion(
                "Default port for HTTP?" , "80"
        );

        qs.add(fixedResponseQuestion3);


        List<String> strList = new ArrayList<>();
        strList.add("Python   Java    ");
        strList.add("A");
        strList.add("60");
        quiz.takeQuiz(s, qs, strList);

        strList = new ArrayList<>();
        strList.add("Python     JaVA    ");
        strList.add("AWS");
        strList.add("60");

        quiz.takeQuiz(s, qs, strList);
        quiz.takeQuiz(s, qs, strList);

        System.out.println(quiz.generateStatistics(s));



    }
}