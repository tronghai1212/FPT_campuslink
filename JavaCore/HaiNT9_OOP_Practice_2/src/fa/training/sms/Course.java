package fa.training.sms;

public class Course {
    private String courseID;
    private String courseName;
    private String dept;

    public Course() {
    }

    public Course(String courseID, String courseName, String dept) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.dept = dept;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String CourseID) {
        this.courseID = CourseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
