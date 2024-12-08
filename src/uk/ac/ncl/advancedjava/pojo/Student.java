package uk.ac.ncl.advancedjava.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

// The Student class represents a student with personal details and statistics related to their attempts and revisions.
public class Student {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Fields to store the student's first name, last name, and date of birth
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

    // Counters for the number of attempts and revisions made by the student
    private int attemptCount = 0;
    private int revisionCount = 0;

    // Field to store the final verdict for the student (e.g., Pass/Fail)
    private String finalVerdict;

    // Constants defining the maximum number of attempts and revisions allowed
    public static final int MAX_NO_ATTEMPTS = 2;

    public static final int MAX_NO_REVISIONS = 2;

    // Constant defining the passing score threshold
    public static final double PASSING_VALUE = 0.5;

    Statistics studentStats = new Statistics();

    /**
     * Constructor.
     *
     * @param firstName
     *            The student's first name.
     * @param lastName
     *            The student's last name.
     * @param dateOfBirth
     *            The student's date of birth.
     */
    public Student(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters for first name, last name, date of birth, and other fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFinalVerdict() {
        return finalVerdict;
    }

    public void setFinalVerdict(String finalVerdict) {
        this.finalVerdict = finalVerdict;
    }

    public int getRevisionCount() {
        return revisionCount;
    }

    public void setRevisionCount(int revisionCount) {
        this.revisionCount = revisionCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public Statistics getStudentStats() {
        return studentStats;
    }

    public void setStudentStats(Statistics studentStats) {
        this.studentStats = studentStats;
    }

    /**
     * This method overrides the {@code equals(Object obj)} method in
     * {@code Object} since there's the need for logical equivalence. Two people
     * are considered to be the same if they have the same name and the same
     * date of birth.
     *
     * @param obj
     *            The object to compare for logical equivalence.
     *
     * @return {@code true} if compared object and this are logical equivalent,
     *         <p>
     *         {@code false} otherwise.
     *         </p>
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        boolean checkDateOfBirth = dateOfBirth.equals(student.dateOfBirth);
        boolean checkFirstName = (Objects.equals(firstName, student.firstName));
        boolean checkLastName = (Objects.equals(lastName, student.lastName));
        return (checkDateOfBirth && checkFirstName && checkLastName);
    }

    /**
     * Overrides the hashCode method to generate a hash code for the Student object.
     * This is based on the first name, last name, and date of birth.
     *
     * @return The hash code for the student object.
     */
    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode = 13 * hashCode + (firstName == null ? 0 : firstName.hashCode());
        hashCode = 13 * hashCode + (lastName == null ? 0 : lastName.hashCode());
        hashCode = 13 * hashCode + (dateOfBirth == null ? 0 : dateOfBirth.hashCode());
        return hashCode;
    }

    /**
     * Overrides the toString method to provide a readable string representation of the Student object,
     * including their name, date of birth, final verdict, and statistics.
     *
     * @return A formatted string representing the student's details.
     */
    @Override
    public String toString() {
        String dateFormatted = dateFormat.format(dateOfBirth);
        return ("Student Name: " + firstName + " " + lastName + "\nDOB: " + dateFormatted + "\nFinal Verdict: " + finalVerdict
                + "\nStatistics: " + studentStats);
    }
}
