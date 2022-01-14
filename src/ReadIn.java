import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadIn {
    public static void readInStudents(String testcaseName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/TestCase1/Students_Info.txt")),
                    "UTF-8"));
            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                String[] strings = lineTxt.split(", ");
                if(strings.length != 3){
                    continue;
                }
                Student student = new Student(strings[0], strings[1], strings[2]);
                GlobalObjects.studentList.add(student);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }

    public static void readInCourses(String testcaseName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/TestCase1/Courses_Info.txt")),
                    "UTF-8"));
            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                String[] strings = lineTxt.split(", ");
                if(strings.length != 3){
                    continue;
                }
                Course course = new Course(strings[0], strings[1], Integer.parseInt(strings[2]));
                GlobalObjects.courseMap.put(course.getCourseId(), course);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }

    public static void readInLearning(String testcaseName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/TestCase1/Learning.txt")),
                    "UTF-8"));
            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                String[] strings = lineTxt.split(", ");
                if(strings.length != 2){
                    continue;
                }
                List<String> list = new ArrayList<>();
                if(GlobalObjects.learningMap.containsKey(strings[0])){
                    list = GlobalObjects.learningMap.get(strings[0]);
                }
                list.add(strings[1]);
                GlobalObjects.learningMap.put(strings[0], list);

            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }



    public static void readInSchemas(String testcaseName, String schemaName) {
        Schema schema = new Schema(schemaName, new HashMap<>(), new HashMap<>());
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/TestCase1/"+schemaName+".txt")),
                    "UTF-8"));
            String lineTxt;
            String lastModuleName = null;

            if((lineTxt = br.readLine()) != null && lineTxt.trim().charAt(0) == '[') {
                String[] strings = lineTxt.trim().split("] ");
                lastModuleName = strings[0].substring(1);
                schema.getModuleRequirement().put(lastModuleName, Integer.parseInt(strings[1]));
                schema.getSchemaCourses().put(lastModuleName, new ArrayList<>());
            }
            while ((lineTxt = br.readLine()) != null) {
                if(lineTxt.trim().charAt(0) == '[') {
                    String[] strings = lineTxt.trim().split("] ");
                    lastModuleName = strings[0].substring(1);
                    schema.getModuleRequirement().put(lastModuleName, Integer.parseInt(strings[1]));
                    schema.getSchemaCourses().put(lastModuleName, new ArrayList<>());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(schema.getSchemaCourses().get(lastModuleName));
                    arrayList.add(lineTxt);
                    schema.getSchemaCourses().put(lastModuleName, arrayList);
                }
            }
            GlobalObjects.schemaMap.put(schema.getSchemaName(), schema);
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }

}
