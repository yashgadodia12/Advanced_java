package uk.ac.ncl.advancedjava.pojo;

import java.util.Arrays;

// The Statistics class stores and manages scores for both revisions and attempts made by students
public class Statistics {

    // Array to store scores for each revision. The size is determined by the constant MAX_NO_REVISIONS from the Student class.
    private final double[] revisionScores = new double[Student.MAX_NO_REVISIONS];

    // Array to store scores for each attempt. The size is determined by the constant MAX_NO_ATTEMPTS from the Student class.
    private final double[] attemptScores = new double[Student.MAX_NO_ATTEMPTS];

    // Method to set the score for a particular revision
    // revisionNumber - the index representing which revision is being updated
    // revisionScore - the score for that particular revision
    public void setRevisionScores(int revisionNumber, double revisionScore) {
            revisionScores[revisionNumber] = revisionScore;
    }

    // Method to set the score for a particular attempt
    // attemptNumber - the index representing which attempt is being updated
    // attemptScore - the score for that particular attempt
    public void setAttemptScores(int attemptNumber, double attemptScore) {
            attemptScores[attemptNumber] = attemptScore;
    }

    // Getter method to retrieve all revision scores
    public double[] getRevisionScores() {
        return revisionScores;
    }

    // Getter method to retrieve all attempt scores
    public double[] getAttemptScores() {
        return attemptScores;
    }

    // Override of the default toString method to provide a readable string representation of the Statistics object
    @Override
    public String toString() {
        // Use Arrays.toString to convert both arrays into readable string format
        return "Statistics{" +
                "revisionScores=" + Arrays.toString(revisionScores) +
                ", attemptScores=" + Arrays.toString(attemptScores) +
                '}';
    }
}
