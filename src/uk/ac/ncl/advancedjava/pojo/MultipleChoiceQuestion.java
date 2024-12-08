package uk.ac.ncl.advancedjava.pojo;

import java.util.Arrays;

// Implements the Question interface, ensuring that this class provides definitions for the methods in the Question interface
public class MultipleChoiceQuestion implements Question {

    // Fields to store the question text (formulation), four answer choices, and the correct answer(s)
    String formulation;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    String answer;

    // Constructor to initialize the question (formulation), four answer choices, and the correct answer(s)
    public MultipleChoiceQuestion(
            String formulation, String choice1,
            String choice2, String choice3, String choice4, String answer) {
        this.formulation = formulation;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    // Method to return the question text (formulation)
    @Override
    public String getFormulation() {
        return formulation;
    }

    // Method to check if the provided answer matches the correct answer(s)
    @Override
    public boolean checkAnswer(String ans) {
        //System.out.println(this.answer + " -- " + ans);
        String[] providedAnswers = ans.split(",");
        String[] expectedAnswers = this.answer.split(",");
        Arrays.sort(providedAnswers);
        Arrays.sort(expectedAnswers);
        return Arrays.equals(providedAnswers, expectedAnswers);
    }

    // Overrides the toString method to provide a readable string representation of the MultipleChoiceQuestion object
    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "formulation='" + formulation + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", choice4='" + choice4 + '\'' +
                '}';
    }
}
