import java.util.List;

public class Learning {
    private String studentId;
    private List<String> learningCourse;

    public Learning(String studentId, List<String> learningCourse) {
        this.studentId = studentId;
        this.learningCourse = learningCourse;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<String> getLearningCourse() {
        return learningCourse;
    }

    public void setLearningCourse(List<String> learningCourse) {
        this.learningCourse = learningCourse;
    }
}
