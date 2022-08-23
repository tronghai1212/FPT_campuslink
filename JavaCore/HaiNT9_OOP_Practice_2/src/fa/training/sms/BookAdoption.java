package fa.training.sms;

public class BookAdoption {
    private String courseID;
    private String adoptionDate;
    private String ISBN;

    public BookAdoption() {
    }

    public BookAdoption(String courseID, String adoptionDate, String ISBN) {
        this.courseID = courseID;
        this.adoptionDate = adoptionDate;
        this.ISBN = ISBN;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(String adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "BookAdoption{" +
                "courseID='" + courseID + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
