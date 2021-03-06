import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        String testcaseName = "TestCase2";
        ReadIn.readInLearning(testcaseName);
//        for (Map.Entry<String, List<String>> entry : GlobalObjects.learningMap.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }


        ReadIn.readInStudents(testcaseName);
//        for (Student student: GlobalObjects.studentList) {
//            System.out.println(student.getId()+"  "+student.getName()+"  "+student.getMajor());
//        }

        ReadIn.readInCourses(testcaseName);
//        for (Course course: GlobalObjects.courseList) {
//            System.out.println(course.getCourseId()+"  "+course.getCourseName()+"  "+course.getCredit());
//        }

        ReadIn.readInSchemas(testcaseName, "Computer Science");
        ReadIn.readInSchemas(testcaseName, "Software Engineering");
//        for (Map.Entry<String, Schema> entry : GlobalObjects.schemaMap.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//            Schema schema = entry.getValue();
//
//
//            System.out.println(schema.getSchemaName());
//            Map<String, List<String>> map = schema.getSchemaCourses();
//            for (Map.Entry<String, List<String>> entry2 : map.entrySet()) {
//                System.out.println("key = " + entry2.getKey());
//                List<String> list = entry2.getValue();
//                for (String s : list) {
//                    System.out.println(s);
//                }
//            }
//        }
        String direction = "Direction A";
        Utils2.getAns(direction);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            String[] strings = command.split(",");
            if(strings[0].equals("swap")) {
                List<Student> studentList = GlobalObjects.studentList;
                for (Student student: studentList) {
                    if(student.getName().equals(strings[1])) {
                        student.setMajor(strings[2]);
                        Utils2.getAns(direction);
                    }
                 }
            } else if(strings[0].equals("readInSchema")) {
                ReadIn.readInSchemas(testcaseName, strings[1]);
                Utils2.getAns(direction);
            } else if(strings[0].equals("calc")) {
                if(strings[1].equals("A")){
                    direction = "Direction A";
                } else if(strings[1].equals("B")) {
                    direction = "Direction B";
                }
                Utils2.getAns(direction);
            }
        }


    }

}

