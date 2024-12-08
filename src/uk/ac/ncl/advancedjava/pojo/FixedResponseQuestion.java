package uk.ac.ncl.advancedjava.pojo;

// Implements the Question interface, meaning this class must provide definitions for the methods in the Question interface
public class FixedResponseQuestion implements Question {

    // Fields to store the question text (formulation) and the correct answer
    String formulation;
    String answer;

    // Constructor to initialize the question (formulation) and its corresponding answer
    public FixedResponseQuestion(String formulation, String answer) {
        this.formulation = formulation;
        this.answer = answer;
    }

    // Method to return the question text (formulation)
    @Override
    public String getFormulation() {
        return formulation;
    }

    // Method to check if the provided answer matches the correct answer
    @Override
    public boolean checkAnswer(String ans) {
        //System.out.println(this.answer + " -- " + ans);
        String trimmedAnswer = ans.replaceAll("\\s+"," ");
        return this.answer.equalsIgnoreCase(trimmedAnswer.trim());
    }

    @Override
    public String toString() {
        return "FixedResponseQuestion{" +
                "formulation='" + formulation + '\'' +
                '}';
    }
}
