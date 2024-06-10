package students;

public class Grade {
    private String courseName;
    private String grade;

    public Grade(String courseName, String grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "courseName='" + courseName + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
