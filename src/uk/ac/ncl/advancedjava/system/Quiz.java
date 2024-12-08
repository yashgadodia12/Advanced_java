package uk.ac.ncl.advancedjava.system;

import uk.ac.ncl.advancedjava.database.FixedResponseQuestionSet;
import uk.ac.ncl.advancedjava.database.MultipleChoiceQuestionSet;
import uk.ac.ncl.advancedjava.util.LibraryUtil;
import uk.ac.ncl.advancedjava.pojo.Question;
import uk.ac.ncl.advancedjava.pojo.Statistics;
import uk.ac.ncl.advancedjava.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quiz {

    // Instances of question sets for fixed response and multiple choice questions
    FixedResponseQuestionSet fixedResponseQuestionSet =
            new FixedResponseQuestionSet();
    MultipleChoiceQuestionSet multipleChoiceQuestionSet =
            new MultipleChoiceQuestionSet();

    // Lists to store selected questions for the quiz and previously selected ones to avoid repetition
    List<Question> selectedQuestions = new ArrayList<>();
    List<Integer> selectedFixedResponseQuestions = new ArrayList<>();
    List<Integer> selectedMultipleChoiceQuestions = new ArrayList<>();

    /**
     * Generates a quiz by selecting random questions from both fixed-response and multiple-choice question sets.
     * The number of questions is determined by the input parameter.
     *
     * @param numberOfQuestions Number of questions to be included in the quiz.
     * @return List of selected questions.
     */
    public List<Question> generateQuiz(int numberOfQuestions) {

        for (int i = 0; i < numberOfQuestions; i++) {

            if ( i % 2 == 0) { // Even index, pick from fixed-response set
                int questionNo;
                do {
                    questionNo = LibraryUtil.getRandom(fixedResponseQuestionSet.getFixedResponseQuestionList().size());
                    //System.out.println(questionNo);
                } while (selectedFixedResponseQuestions.contains(questionNo));

                selectedQuestions.add(fixedResponseQuestionSet.getFixedResponseQuestionList().get(questionNo));
                selectedFixedResponseQuestions.add(questionNo);

                //System.out.println("Question - " + fixedResponseQuestionSet.getFixedResponseQuestionList().get(questionNo));

            } else { // Odd index, pick from multiple-choice set
                int questionNo;

                do {
                    questionNo = LibraryUtil.getRandom(multipleChoiceQuestionSet.getMultipleChoiceQuestionList().size());
                    //System.out.println(questionNo);
                } while (selectedMultipleChoiceQuestions.contains(questionNo));
                selectedQuestions.add(multipleChoiceQuestionSet.getMultipleChoiceQuestionList().get(questionNo));
                selectedMultipleChoiceQuestions.add(questionNo);

                //System.out.println("Question - " + multipleChoiceQuestionSet.getMultipleChoiceQuestionList().get(questionNo));

            }
        }

        return selectedQuestions;

    }

    /**
     * Generates a revision quiz similarly to the main quiz but specifically for revision purposes.
     *
     * @param numberOfQuestions Number of questions for the revision.
     * @return List of selected questions.
     */
    public List<Question> revise(int numberOfQuestions) {

        for (int i = 0; i < numberOfQuestions; i++) {

            if ( i % 2 == 0) {
                int questionNo;
                do {
                    questionNo = LibraryUtil.getRandom(fixedResponseQuestionSet.getFixedResponseQuestionList().size());
                } while (selectedFixedResponseQuestions.contains(questionNo));

                selectedQuestions.add(fixedResponseQuestionSet.getFixedResponseQuestionList().get(questionNo));
                selectedFixedResponseQuestions.add(questionNo);

                //System.out.println("Question - " + fixedResponseQuestionSet.getFixedResponseQuestionList().get(questionNo));

            } else {
                int questionNo;

                do {
                    questionNo = LibraryUtil.getRandom(multipleChoiceQuestionSet.getMultipleChoiceQuestionList().size());
                } while (selectedMultipleChoiceQuestions.contains(questionNo));
                selectedQuestions.add(multipleChoiceQuestionSet.getMultipleChoiceQuestionList().get(questionNo));
                selectedMultipleChoiceQuestions.add(questionNo);

                //System.out.println("Question - " + multipleChoiceQuestionSet.getMultipleChoiceQuestionList().get(questionNo));

            }
        }

        return selectedQuestions;
    }

    /**
     * Handles the process of taking a quiz, calculating the score, and updating the student's statistics.
     *
     * @param student The student taking the quiz.
     * @param questions List of questions for the quiz.
     * @param answers List of answers provided by the student.
     * @return The score obtained in this quiz attempt.
     */
    public double takeQuiz(Student student, List<Question> questions, List<String> answers) {
        int correctAns = 0;
        double attemptScore = 0;

        // If the student already has a final verdict (PASS or FAIL), skip quiz
        if(Objects.nonNull(student.getFinalVerdict())) {
            System.out.println("Student has already been assigned a grade - " + student.getFinalVerdict());
            System.out.println("Details below: ");
            System.out.println(student);
        } else {
            // Check if the student has already reached the max number of attempts
            if (student.getAttemptCount() == Student.MAX_NO_ATTEMPTS) {
                System.out.println("Student has already taken max attempts - " + Student.MAX_NO_ATTEMPTS);
                System.out.println("Details below: ");
                System.out.println(student);
            } else {
                selectedQuestions = new ArrayList<>();
                // Check each question and compare student's answer to the correct one
                for (int i = 0; i < questions.size(); i++) {
                    Question question = questions.get(i);
                    boolean isCorrect = question.checkAnswer(answers.get(i));
                    if (isCorrect) {
                        correctAns++;
                    }
                }
                attemptScore = (double) correctAns / questions.size(); // Calculate score
                Statistics stats = student.getStudentStats();
                stats.setAttemptScores(student.getAttemptCount(), attemptScore); // Record attempt score
                student.setAttemptCount(student.getAttemptCount() + 1);  // Increment attempt count

                // Check if the student passed
                if (attemptScore >= Student.PASSING_VALUE) {
                    student.setFinalVerdict("PASS");
                }

                // If max attempts are reached and no PASS verdict, mark as FAIL
                if(student.getAttemptCount() == Student.MAX_NO_ATTEMPTS && Objects.isNull(student.getFinalVerdict())) {
                    student.setFinalVerdict("FAIL");
                }
            }
        }

        return attemptScore;
    }

    /**
     * Handles the process of taking a revision quiz and recording the student's score for revisions.
     *
     * @param student The student taking the revision quiz.
     * @param questions List of revision questions.
     * @param answers List of student's answers.
     * @return The score obtained in the revision.
     */
    public double takeRevisionQuiz(Student student, List<Question> questions, List<String> answers) {

        int correctAns = 0;
        double revisionScore = 0;

        if(Objects.nonNull(student.getFinalVerdict())) {
            System.out.println("Student has already been assigned a grade - " + student.getFinalVerdict());
            System.out.println("Details below: ");
            System.out.println(student);
        } else {
            if (student.getAttemptCount() == Student.MAX_NO_REVISIONS) {
                System.out.println("Student has already taken max revisions - " + Student.MAX_NO_REVISIONS);
                System.out.println("Details below: ");
                System.out.println(student);
            } else {
                selectedQuestions = new ArrayList<>();

                for (int i = 0; i < questions.size(); i++) {
                    Question question = questions.get(i);
                    boolean isCorrect = question.checkAnswer(answers.get(i));
                    if (isCorrect) {
                        correctAns++;
                    }
                }
                revisionScore = (double) correctAns / questions.size();
                Statistics stats = student.getStudentStats();
                stats.setRevisionScores(student.getRevisionCount(), revisionScore);
                student.setRevisionCount(student.getRevisionCount() + 1);
            }
        }

        return revisionScore;

    }

    /**
     * Generates the statistics and overall information for the student.
     *
     * @param student The student whose statistics are being generated.
     * @return A string representation of the student's statistics and status.
     */
    public String generateStatistics(Student student) {
        return student.toString();
    }
}
