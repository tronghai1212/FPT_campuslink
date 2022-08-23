package fa.training.sms;

public class Student {
    private String SSN;
    private String name;
    private String major;
    private String birth_date;

    public Student() {
    }

    public Student(String SSN, String name, String major, String birth_date) {
        this.SSN = SSN;
        this.name = name;
        this.major = major;
        this.birth_date = birth_date;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SSN='" + SSN + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
