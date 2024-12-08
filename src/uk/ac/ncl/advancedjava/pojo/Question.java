package uk.ac.ncl.advancedjava.pojo;

// The Question interface defines the contract for any type of question (e.g., FixedResponseQuestion, MultipleChoiceQuestion)
public interface Question {

    // Method to retrieve the question text (formulation)
    // Every class implementing this interface must provide its own version of this method
    public String getFormulation();

    // Method to check if the provided answer matches the correct answer
    // Implementing classes will define how they check answers (fixed, multiple-choice, etc.)
    public boolean checkAnswer(String ans);

}
