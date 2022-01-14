public class Course {
    private String courseId;
    private String courseName;
    private int credit;
    private String replaceCourseId = "none";

    public Course(String courseId, String courseName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
    }

    public Course(String courseId, String courseName, int credit, String replaceCourseId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.replaceCourseId = replaceCourseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getReplaceCourseId() {
        return replaceCourseId;
    }

    public void setReplaceCourseId(String replaceCourseId) {
        this.replaceCourseId = replaceCourseId;
    }
}
