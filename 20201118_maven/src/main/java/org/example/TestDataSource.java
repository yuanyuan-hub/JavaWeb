package org.example;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDataSource {

    public static void main(String[] args) {

//        query("计算机系2019级1班");
//        List<Info> list = query("中文系2019级3班");
        //简单的操作命令对象Statement，可能存在SQL注入问题
        List<Info> list = query("中文系2019级3班' or '1'='1");
    }

    //模拟文本框输入班级名称，查询信息：
    //实现一个方法，参数为传入的班级名称，返回类型为List<Info>
    public static List<Info> query(String name) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // JDBC操作的第一步：创建连接
            // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法区，并执行该类的静态方法块、静态属性。
            Class.forName("com.mysql.jdbc.Driver");

            // 创建数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            System.out.println(connection);

            //第二步：创建操作命令对象Statement
            statement = connection.createStatement();

            //第三步：执行sql
            String sql = "select " +
                    "cls.name classes_name," +
                    "stu.sn," +
                    "stu.name student_name," +
                    "stu.qq_mail," +
                    "cou.name course_name," +
                    "sco.score" +
                    " from" +
                    "   classes cls,student stu,course cou,score sco" +
                    "       where cls.id=stu.classes_id" +
                    "   and stu.id=sco.student_id" +
                    "   and cou.id=sco.course_id" +
                    "   and cls.name='" +
                    name+
                    "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);

            List<Info> list = new ArrayList<>();//list.contains(Object o)
            //第四步：处理结果集（查询操作）
            while (resultSet.next()){
                int sn = resultSet.getInt("sn");
                String classesName = resultSet.getString("classes_name");
                String studentName = resultSet.getString("student_name");
                String qqMail = resultSet.getString("qq_mail");
                String courseName = resultSet.getString("course_name");
                BigDecimal score = resultSet.getBigDecimal("score");
                System.out.printf("classesName=%s,sn=%s,studentName=%s,qqMail=%s,"
                                +"courseName=%s,score=%s"
                                +"%n",
                        classesName, sn, studentName, qqMail, courseName, score);
                Info info = new Info();
                info.setClassesName(classesName);
                info.setSn(sn);
                info.setStudentName(studentName);
                info.setQqMail(qqMail);
                info.setCourseName(courseName);
                info.setScore(score);
                list.add(info);
            }
            System.out.println(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            //执行某个功能，如果出现异常，建议再次抛出异常
            throw new RuntimeException("查询班级信息出错了", e);
        } finally {
            //第五步：无论如何，都需要释放资源
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 一般来说，对象中属性不提供对外直接修改
     * 1. Getter/Setter方法
     * 2. 构造方法来设置
     */
    private static class Info{
        private String classesName;
        private Integer sn;
        private String studentName;
        private String qqMail;
        private String courseName;
        private BigDecimal score;

        @Override
        public String toString() {
            return "Info{" +
                    "classesName='" + classesName + '\'' +
                    ", sn='" + sn + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", qqMail='" + qqMail + '\'' +
                    ", courseName='" + courseName + '\'' +
                    ", score=" + score +
                    '}';
        }

        public Integer getSn() {
            return sn;
        }

        public void setSn(Integer sn) {
            this.sn = sn;
        }

        public String getClassesName() {
            return classesName;
        }

        public void setClassesName(String classesName) {
            this.classesName = classesName;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getQqMail() {
            return qqMail;
        }

        public void setQqMail(String qqMail) {
            this.qqMail = qqMail;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public BigDecimal getScore() {
            return score;
        }

        public void setScore(BigDecimal score) {
            this.score = score;
        }
    }
}
