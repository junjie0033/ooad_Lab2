//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void getAns() {

        for (Student student : GlobalObjects.studentList) {
//            JSONObject root = new JSONObject();
//            root.put("学号",student.getId());
//            root.put("姓名", student.getName());
//            root.put("专业", student.getMajor());

//            JSONArray jsonArray1 = new JSONArray();

            System.out.println("进度汇总："+student.getId()+","+student.getName()+","+student.getMajor());
            List<String> learningList = new ArrayList<>();
            learningList.addAll(GlobalObjects.learningMap.get(student.getId()));

            Schema schema = GlobalObjects.schemaMap.get(student.getMajor());
            if(schema == null) {
                System.out.println("There is no "+student.getMajor()+" schema");
                return;
            }
            List<String> list = new ArrayList<>();
            list.addAll(schema.getSchemaCourses().get("Basic Compulsory"));
            list.addAll(schema.getSchemaCourses().get("Major Compulsory"));
            List<String> compulsoryList = new ArrayList<>();
            int compulsoryCompNum = 0;
            int compulsoryCompCredit = 0;
            for (String s : list) {
                if(learningList.contains(s)) {
                    compulsoryList.add(s);
                    learningList.remove(s);
                    compulsoryCompNum++;
                    compulsoryCompCredit +=GlobalObjects.courseMap.get(s).getCredit();
                }
            }

            List<String> majorElectiveList = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Major Elective"));
            int meCompNum = 0;
            int meCompCredit = 0;
            for (String s: list) {
                if(learningList.contains(s)) {
                    majorElectiveList.add(s);
                    learningList.remove(s);
                    meCompNum++;
                    meCompCredit += GlobalObjects.courseMap.get(s).getCredit();
                }
            }

            List<String> module1List = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Module 1"));
            int module1CompNum = 0;
            int module1CompCredit = 0;
            for (String s : list) {
                if(learningList.contains(s)) {
                    module1List.add(s);
                    learningList.remove(s);
                    module1CompNum++;
                    module1CompCredit += GlobalObjects.courseMap.get(s).getCredit();
                }
            }

            List<String> module2List = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Module 2"));
            int module2CompNum = 0;
            int module2CompCredit = 0;
            for (String s : list) {
                if(learningList.contains(s)) {
                    module2List.add(s);
                    learningList.remove(s);
                    module2CompNum++;
                    module2CompCredit += GlobalObjects.courseMap.get(s).getCredit();
                }
            }

            List<String> eleList = new ArrayList<>();
            eleList.addAll(learningList);
            int eleCompNum = 0;
            int eleCompCredit = 0;
            for (String s : eleList) {
                eleCompNum++;
                eleCompCredit += GlobalObjects.courseMap.get(s).getCredit();
            }

            System.out.println("课程类别" + "      "
                    + "已修学分" + "      "
                    + "已修课程数量" + "      "
                    + "要求学分/课程数量" + "      "
                    + "进度情况"+"     ");

            int compRequireCredit = schema.getModuleRequirement().get("Basic Compulsory")+schema.getModuleRequirement().get("Major Compulsory");
            System.out.println("必修的基础课与专业基础课"+"      "
                    + compulsoryCompCredit+"      "
                    + compulsoryCompNum+"     "
                    + compRequireCredit+"     "
                    + Math.min(compulsoryCompCredit*100/compRequireCredit,100)+"%"
            );
//            jsonArray1.add(getJsonObj("必修的基础课与专业基础课", compulsoryCompCredit+"",compulsoryCompNum+"",compRequireCredit+"",Math.min(compulsoryCompCredit*100/compRequireCredit,100)+"%"));
            int meRequireCredit = schema.getModuleRequirement().get("Major Elective");
            System.out.println("专业选修课"+"      "
                    + meCompCredit+"      "
                    + meCompNum+"     "
                    + meRequireCredit+"     "
                    + Math.min(meCompCredit*100/meRequireCredit, 100)+"%"
            );
//            jsonArray1.add(getJsonObj("专业选修课", meCompCredit+"", meCompNum+"",meRequireCredit+"",Math.min(meCompCredit*100/meRequireCredit, 100)+"%"));
            int module1RequireCredit = schema.getModuleRequirement().get("Module 1");
            System.out.println("模块课 1"+"      "
                    + module1CompCredit+"      "
                    + module1CompNum+"     "
                    + module1RequireCredit+"     "
                    + Math.min(module1CompCredit*100/module1RequireCredit,100)+"%"
            );
//            jsonArray1.add(getJsonObj("模块课 1", module1CompCredit+"", module1CompNum+"", module1RequireCredit+"", Math.min(module1CompCredit*100/module1RequireCredit,100)+"%"));
            int module2RequireCredit = schema.getModuleRequirement().get("Module 2");
            System.out.println("模块课 2"+"      "
                    + module2CompCredit+"      "
                    + module2CompNum+"     "
                    + module2RequireCredit+"     "
                    + Math.min(module2CompCredit*100/module2RequireCredit,100)+"%"
            );
//            jsonArray1.add(getJsonObj("模块课 2",module2CompCredit+"", module2CompNum+"",module2RequireCredit+"", Math.min(module2CompCredit*100/module2RequireCredit,100)+"%"));
            int eleRequireCredit = schema.getModuleRequirement().get("Other Elective");
            System.out.println("任意选修课"+"      "
                    + eleCompCredit+"      "
                    + eleCompNum+"     "
                    + eleRequireCredit+"     "
                    + Math.min(eleCompCredit*100/eleRequireCredit,100)+"%"
            );
//            jsonArray1.add(getJsonObj("任意选修课", eleCompCredit+"", eleCompNum+"", eleRequireCredit+"", Math.min(eleCompCredit*100/eleRequireCredit,100)+"%"));
//            root.put("进度汇总", jsonArray1);

            System.out.println("进度详情");

            System.out.println("必修的基础课与专业基础课");
//            JSONObject jsonObject2 = new JSONObject();
//            JSONArray jsonArray21 = new JSONArray();
            printTemplate();
            for (String s : compulsoryList) {
                System.out.println(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit());
//                jsonArray21.add(getJsonBoj2(s+"-"+GlobalObjects.courseMap.get(s).getCourseName(), GlobalObjects.courseMap.get(s).getCredit(), null));
            }
            System.out.println("总结"+"     "+"要求"+compRequireCredit+"学分，缺少"+(Math.max(compRequireCredit - compulsoryCompCredit, 0))+"学分     "+Math.min(compulsoryCompCredit*100/compRequireCredit,100)+"%");
//            jsonArray21.add(getJsonObj3("要求"+compRequireCredit+"学分，缺少"+(Math.max(compRequireCredit - compulsoryCompCredit, 0))+"学分", Math.min(compulsoryCompCredit*100/compRequireCredit,100)+"%"));
//            jsonObject2.put("必修的基础课与专业基础课", jsonArray21);


            System.out.println("专业选修课");
//            JSONObject jsonObject3 = new JSONObject();
//            JSONArray jsonArray31 = new JSONArray();
            printTemplate();
            for (String s : majorElectiveList) {
                System.out.println(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit());
//                jsonArray31.add(getJsonBoj2(s+"-"+GlobalObjects.courseMap.get(s).getCourseName(), GlobalObjects.courseMap.get(s).getCredit(),null));
            }
            System.out.println("总结"+"     "+"要求"+meRequireCredit+"学分，缺少"+(Math.max(meRequireCredit - meCompCredit, 0))+"学分     "+Math.min(meCompCredit*100/meRequireCredit,100)+"%");
//            jsonArray31.add(getJsonObj3("要求"+meRequireCredit+"学分，缺少"+(Math.max(meRequireCredit - meCompCredit, 0))+"学分", Math.min(meCompCredit*100/meRequireCredit,100)+"%"));
//            jsonObject3.put("专业选修课", jsonArray31);


            System.out.println("模块课 1");
//            JSONObject jsonObject4 = new JSONObject();
//            JSONArray jsonArray41 = new JSONArray();
            printTemplate();
            for (String s : module1List) {
                System.out.println(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit());
//                jsonArray41.add(getJsonBoj2(s+"-"+GlobalObjects.courseMap.get(s).getCourseName(), GlobalObjects.courseMap.get(s).getCredit(), null));
            }
            System.out.println("总结"+"     "+"要求"+module1RequireCredit+"门课，缺少"+(Math.max(module1RequireCredit - module1CompNum, 0))+"门课     "+Math.min(module1CompNum*100/module1RequireCredit,100)+"%");
//            jsonArray41.add(getJsonObj3("要求"+module1RequireCredit+"门课，缺少"+(Math.max(module1RequireCredit - module1CompNum, 0))+"门课", Math.min(module1CompNum*100/module1RequireCredit,100)+"%"));
//            jsonObject4.put("模块课 1", jsonArray41);


            System.out.println("模块课 2");
//            JSONObject jsonObject5 = new JSONObject();
//            JSONArray jsonArray51 = new JSONArray();
            printTemplate();
            for (String s : module2List) {
                System.out.println(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit());
                jsonArray51.add(getJsonBoj2(s+"-"+GlobalObjects.courseMap.get(s).getCourseName(), GlobalObjects.courseMap.get(s).getCredit(), null));
            }
            System.out.println("总结"+"     "+"要求"+module2RequireCredit+"门课，缺少"+(Math.max(module2RequireCredit - module2CompNum, 0))+"门课     "+Math.min(module2CompNum*100/module2RequireCredit,100)+"%");
            jsonArray51.add(getJsonObj3("要求"+module2RequireCredit+"门课，缺少"+(Math.max(module2RequireCredit - module2CompNum, 0))+"门课", Math.min(module2CompNum*100/module2RequireCredit,100)+"%"));
            jsonObject5.put("模块课 2", jsonArray51);


            System.out.println("任意选修课");
            JSONObject jsonObject6 = new JSONObject();
            JSONArray jsonArray61 = new JSONArray();
            printTemplate();
            for (String s : eleList) {
                System.out.println(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit());
                jsonArray61.add(getJsonBoj2(s+"-"+GlobalObjects.courseMap.get(s).getCourseName(), GlobalObjects.courseMap.get(s).getCredit(), null));
            }
            System.out.println("总结"+"     "+"要求"+eleRequireCredit+"学分，缺少"+(Math.max(eleRequireCredit - eleCompCredit, 0))+"学分     "+Math.min(eleCompCredit*100/eleRequireCredit,100)+"%");
            jsonArray61.add(getJsonObj3("要求"+eleRequireCredit+"学分，缺少"+(Math.max(eleRequireCredit - eleCompCredit, 0))+"学分", Math.min(eleCompCredit*100/eleRequireCredit,100)+"%"));
            jsonObject6.put("任意选修课", jsonObject6);

            JSONObject jsonObject00 = new JSONObject();
            jsonObject00.put("必修的基础课与专业基础课", jsonArray21);
            jsonObject00.put("专业选修课", jsonArray31);
            jsonObject00.put("模块课 1", jsonArray41);
            jsonObject00.put("模块课 2", jsonArray51);
            jsonObject00.put("任意选修课", jsonObject6);
            root.put("进度详情", jsonObject00);
            CreateFileUtil.createJsonFile(root.toString(), "src/output/",student.getName());
        }
    }

    public static void printTemplate(){
        System.out.println("课程" + "      "
                + "学分" + "      "
                + "备注"+"     ");
    }

    public static JSONObject getJsonObj(String type, String credit, String num, String require, String con) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("课程类型", type);
        jsonObject.put("已修学分", credit);
        jsonObject.put("已修课程数量", num);
        jsonObject.put("要求学分/课程数量", require);
        jsonObject.put("进度情况", con);
        return jsonObject;
    }

    public static JSONObject getJsonBoj2(String course, int credit, String bz) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("课程",course);
        jsonObject.put("学分", credit);
        jsonObject.put("备注", bz);
        return jsonObject;
    }

    public static JSONObject getJsonObj3(String conclusion, String bz) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("总结", conclusion);
        jsonObject.put("bz",bz);
        return jsonObject;
    }


}
