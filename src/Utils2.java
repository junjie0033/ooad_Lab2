import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils2 {
    public static void getAns(String direction) {
        Map<String, String> replaceMap = new HashMap<>();
        for (Student student : GlobalObjects.studentList) {
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
                String repCourseId = GlobalObjects.courseMap.get(s).getReplaceCourseId();
                if(learningList.contains(s)) {
                    compulsoryList.add(s);
                    learningList.remove(s);
                    compulsoryCompNum++;
                    compulsoryCompCredit +=GlobalObjects.courseMap.get(s).getCredit();
                } else if(learningList.contains(repCourseId)) {
                    compulsoryList.add(s);
                    learningList.remove(repCourseId);
                    compulsoryCompNum++;
                    compulsoryCompCredit +=GlobalObjects.courseMap.get(s).getCredit();
                    replaceMap.put(s, repCourseId);
                }
            }

            List<String> majorElectiveList = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Major Elective"));
            int meCompNum = 0;
            int meCompCredit = 0;
            for (String s: list) {
                String repCourseId = GlobalObjects.courseMap.get(s).getReplaceCourseId();
                if(learningList.contains(s)) {
                    majorElectiveList.add(s);
                    learningList.remove(s);
                    meCompNum++;
                    meCompCredit += GlobalObjects.courseMap.get(s).getCredit();
                } else if(learningList.contains(repCourseId)) {
                    majorElectiveList.add(s);
                    learningList.remove(repCourseId);
                    meCompNum++;
                    meCompCredit += GlobalObjects.courseMap.get(s).getCredit();
                    replaceMap.put(s, repCourseId);
                }
            }

            List<String> module1List = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Module 1"));
            int module1CompNum = 0;
            int module1CompCredit = 0;
            for (String s : list) {
                String repCourseId = GlobalObjects.courseMap.get(s).getReplaceCourseId();
                if(learningList.contains(s)) {
                    module1List.add(s);
                    learningList.remove(s);
                    module1CompNum++;
                    module1CompCredit += GlobalObjects.courseMap.get(s).getCredit();
                } else if(learningList.contains(repCourseId)) {
                    module1List.add(s);
                    learningList.remove(repCourseId);
                    module1CompNum++;
                    module1CompCredit += GlobalObjects.courseMap.get(s).getCredit();
                    replaceMap.put(s, repCourseId);
                }
            }

            List<String> module2List = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Module 2"));
            int module2CompNum = 0;
            int module2CompCredit = 0;
            for (String s : list) {
                String repCourseId = GlobalObjects.courseMap.get(s).getReplaceCourseId();
                if(learningList.contains(s)) {
                    module2List.add(s);
                    learningList.remove(s);
                    module2CompNum++;
                    module2CompCredit += GlobalObjects.courseMap.get(s).getCredit();
                } else if(learningList.contains(repCourseId)) {
                    module2List.add(s);
                    learningList.remove(repCourseId);
                    module2CompNum++;
                    module2CompCredit += GlobalObjects.courseMap.get(s).getCredit();
                    replaceMap.put(s, repCourseId);
                }
            }


            List<String> directionAList = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Direction A"));
            int dirACompNum = 0;
            int dirACompCredit = 0;
            for (String s : list) {
                String repCourseId = GlobalObjects.courseMap.get(s).getReplaceCourseId();
                if(learningList.contains(s)) {
                    directionAList.add(s);
                    learningList.remove(s);
                    dirACompNum++;
                    dirACompCredit += GlobalObjects.courseMap.get(s).getCredit();
                } else if(learningList.contains(repCourseId)) {
                    directionAList.add(s);
                    learningList.remove(repCourseId);
                    dirACompNum++;
                    dirACompCredit += GlobalObjects.courseMap.get(s).getCredit();
                    replaceMap.put(s, repCourseId);
                }
            }

            List<String> directionBList = new ArrayList<>();
            list.clear();
            list.addAll(schema.getSchemaCourses().get("Direction B"));
            int dirBCompNum = 0;
            int dirBCompCredit = 0;
            for (String s : list) {
                String repCourseId = GlobalObjects.courseMap.get(s).getReplaceCourseId();
                if(learningList.contains(s)) {
                    directionBList.add(s);
                    learningList.remove(s);
                    dirBCompNum++;
                    dirBCompCredit += GlobalObjects.courseMap.get(s).getCredit();
                } else if(learningList.contains(repCourseId)) {
                    directionBList.add(s);
                    learningList.remove(repCourseId);
                    dirBCompNum++;
                    dirBCompCredit += GlobalObjects.courseMap.get(s).getCredit();
                    replaceMap.put(s, repCourseId);
                }
            }


            List<String> eleList = new ArrayList<>();
            eleList.addAll(learningList);
            int eleCompNum = 0;
            int eleCompCredit = 0;
            List<String> tmpList = new ArrayList<>();
            List<String> tmpList2 = new ArrayList<>();
            for (String s : eleList) {
                if(!GlobalObjects.courseMap.get(s).getReplaceCourseId().equals("none")) {
                    for (Map.Entry<String, Course> entry : GlobalObjects.courseMap.entrySet()) {
                        if(entry.getValue().getReplaceCourseId().equals(s)) {
//                            eleList.remove(s);
                            tmpList.add(s);
//                            eleList.add(entry.getKey());
                            tmpList2.add(entry.getKey());
                            replaceMap.put(entry.getKey(), s);

                        }
                    }
                }
                eleCompNum++;
                eleCompCredit += GlobalObjects.courseMap.get(s).getCredit();
            }
            for (String s: tmpList) {
                eleList.remove(s);
            }
            for (String s: tmpList2) {
                eleList.add(s);
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
            int meRequireCredit = schema.getModuleRequirement().get("Major Elective");
            System.out.println("专业选修课"+"      "
                    + meCompCredit+"      "
                    + meCompNum+"     "
                    + meRequireCredit+"     "
                    + Math.min(meCompCredit*100/meRequireCredit, 100)+"%"
            );
            int module1RequireCredit = schema.getModuleRequirement().get("Module 1");
            System.out.println("模块课 1"+"      "
                    + module1CompCredit+"      "
                    + module1CompNum+"     "
                    + module1RequireCredit+"     "
                    + Math.min(module1CompCredit*100/module1RequireCredit,100)+"%"
            );
            int module2RequireCredit = schema.getModuleRequirement().get("Module 2");
            System.out.println("模块课 2"+"      "
                    + module2CompCredit+"      "
                    + module2CompNum+"     "
                    + module2RequireCredit+"     "
                    + Math.min(module2CompCredit*100/module2RequireCredit,100)+"%"
            );
            int eleRequireCredit = schema.getModuleRequirement().get("Other Elective");
            System.out.println("任意选修课"+"      "
                    + eleCompCredit+"      "
                    + eleCompNum+"     "
                    + eleRequireCredit+"     "
                    + Math.min(eleCompCredit*100/eleRequireCredit,100)+"%"
            );

            int dirRequireCredit = schema.getModuleRequirement().get(direction);
            List<String> directionList;
            int dirCompCredit = 0;
            int dirCompNum = 0;
            if(direction.equals("Direction A")) {
                directionList = directionAList;
                dirCompCredit = dirACompCredit;
                dirCompNum = dirACompNum;
            } else {
                directionList = directionBList;
                dirCompCredit = dirBCompCredit;
                dirCompNum = dirBCompNum;
            }
            System.out.println("方向课"+direction.substring(10)+"      "
                    + dirCompCredit+"      "
                    + dirCompNum+"     "
                    + dirRequireCredit+"     "
                    + Math.min(dirCompCredit*100/dirRequireCredit,100)+"%"
            );


            System.out.println("进度详情");
            System.out.println("必修的基础课与专业基础课");
            printTemplate();
            for (String s : compulsoryList) {
                System.out.print(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit()+"     ");
                if(replaceMap.containsKey(s)) {
                    System.out.println(replaceMap.get(s)+"-"+GlobalObjects.courseMap.get(replaceMap.get(s)).getCourseName());
                } else {
                    System.out.println();
                }
            }
            System.out.println("总结"+"     "+"要求"+compRequireCredit+"学分，缺少"+(Math.max(compRequireCredit - compulsoryCompCredit, 0))+"学分     "+Math.min(compulsoryCompCredit*100/compRequireCredit,100)+"%");

            System.out.println("专业选修课");
            printTemplate();
            for (String s : majorElectiveList) {
                System.out.print(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit()+"     ");
                if(replaceMap.containsKey(s)) {
                    System.out.println(replaceMap.get(s)+"-"+GlobalObjects.courseMap.get(replaceMap.get(s)).getCourseName());
                } else {
                    System.out.println();
                }
            }
            System.out.println("总结"+"     "+"要求"+meRequireCredit+"学分，缺少"+(Math.max(meRequireCredit - meCompCredit, 0))+"学分     "+Math.min(meCompCredit*100/meRequireCredit,100)+"%");

            System.out.println("模块课 1");
            printTemplate();
            for (String s : module1List) {
                System.out.print(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit()+"     ");
                if(replaceMap.containsKey(s)) {
                    System.out.println(replaceMap.get(s)+"-"+GlobalObjects.courseMap.get(replaceMap.get(s)).getCourseName());
                } else {
                    System.out.println();
                }
            }
            System.out.println("总结"+"     "+"要求"+module1RequireCredit+"门课，缺少"+(Math.max(module1RequireCredit - module1CompNum, 0))+"门课     "+Math.min(module1CompNum*100/module1RequireCredit,100)+"%");

            System.out.println("模块课 2");
            printTemplate();
            for (String s : module2List) {
                System.out.print(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit()+"     ");
                if(replaceMap.containsKey(s)) {
                    System.out.println(replaceMap.get(s)+"-"+GlobalObjects.courseMap.get(replaceMap.get(s)).getCourseName());
                } else {
                    System.out.println();
                }
            }
            System.out.println("总结"+"     "+"要求"+module2RequireCredit+"门课，缺少"+(Math.max(module2RequireCredit - module2CompNum, 0))+"门课     "+Math.min(module2CompNum*100/module2RequireCredit,100)+"%");

            System.out.println("方向课 "+direction.substring(10));
            printTemplate();
            for (String s : directionList) {
                System.out.print(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit()+"     ");
                if(replaceMap.containsKey(s)) {
                    System.out.println(replaceMap.get(s)+"-"+GlobalObjects.courseMap.get(replaceMap.get(s)).getCourseName());
                } else {
                    System.out.println();
                }
            }
            System.out.println("总结"+"     "+"要求"+dirRequireCredit+"学分，缺少"+(Math.max(dirRequireCredit - dirCompCredit, 0))+"门课     "+Math.min(dirCompCredit*100/dirRequireCredit,100)+"%");


            System.out.println("任意选修课");
            printTemplate();



            for (String s : eleList) {
                System.out.print(s+"-"+GlobalObjects.courseMap.get(s).getCourseName()+"     "+GlobalObjects.courseMap.get(s).getCredit()+"     ");
                if(replaceMap.containsKey(s)) {
                    System.out.println(replaceMap.get(s)+"-"+GlobalObjects.courseMap.get(replaceMap.get(s)).getCourseName());
                } else {
                    System.out.println();
                }
            }
            System.out.println("必修的基础课与专业基础课超出学分"+"     "+(Math.max(compulsoryCompCredit-compRequireCredit,0)));
            System.out.println("专业选修课超出学分"+"     "+Math.max(meCompCredit-meRequireCredit,0));
            System.out.println("模块课 1超出学分"+"     "+Math.max(module1CompCredit-module1RequireCredit, 0));
            System.out.println("模块课 2超出学分"+"     "+Math.max(module2CompCredit-module2RequireCredit, 0));
            System.out.println("方向课 B超出学分"+"     "+Math.max(dirCompCredit-dirRequireCredit, 0));
            int totalCredit = Math.max(compulsoryCompCredit-compRequireCredit,0)
                    +Math.max(meCompCredit-meRequireCredit,0)
                    +Math.max(module1CompCredit-module1RequireCredit, 0)
                    +Math.max(module2CompCredit-module2RequireCredit, 0)
                    +Math.max(dirCompCredit-dirRequireCredit, 0);
            System.out.println("总结"+"     "+"要求"+eleRequireCredit+"学分，缺少"+(Math.max(eleRequireCredit - eleCompCredit, 0))+"学分     超出"+totalCredit+"学分。     "+Math.min(eleCompCredit*100/eleRequireCredit,100)+"%");

        }
    }

    public static void printTemplate(){
        System.out.println("课程" + "      "
                + "学分" + "      "
                + "备注"+"     ");
    }
}
