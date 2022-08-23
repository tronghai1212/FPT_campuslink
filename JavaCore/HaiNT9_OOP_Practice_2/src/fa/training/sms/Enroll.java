package fa.training.sms;

public class Enroll {
    private String SSN;
    private String courseID;
    private String enrollDate;
    private Integer grade;

    public Enroll() {
    }

    public Enroll(String SSN, String courseID, String enrollDate, int grade) {
        this.SSN = SSN;
        this.courseID = courseID;
        this.enrollDate = enrollDate;
        this.grade = grade;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "SSN='" + SSN + '\'' +
                ", courseID='" + courseID + '\'' +
                ", enrollDate=" + enrollDate +
                ", grade=" + grade +
                '}';
    }
}
