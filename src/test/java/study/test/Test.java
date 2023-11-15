package study.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dzy
 * @time 2023/1/28 16:18
 */

public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        Test test = new Test();
//        String date = "20220131";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Date date1 = sdf.parse(date);
//        Calendar now = Calendar.getInstance();
//        now.setTime(date1);
//        System.out.println(String.valueOf(now.get(Calendar.YEAR)));
//        System.out.println(String.valueOf(now.get(Calendar.MONTH)+1));
//        System.out.println(String.valueOf(now.get(Calendar.DAY_OF_MONTH)));
//        long s = System.currentTimeMillis();
//        String s = null;
//        System.out.println(s.isEmpty());
//        System.out.println(s);

//        mapTest();

//        boolean lastDayOfMonth = isLastDayOfMonth(date1);
//        System.out.println(lastDayOfMonth);

//        StringBuffer s = new StringBuffer("12");
////        String s = "12";
//        Demo dec = new Demo();
//        dec.apped (s);
//        System.out.println(s);
//        test.apped(s);
//        System.out.println(s);

//        listTest();

//        listTestLamda();
//        exceptionTest();
//        System.out.println(dateBefore());
//        testArrayList();

//        strIsNum();

//        calenderTest();

        fastjsonTest();
    }

    public static void fastjsonTest(){
        String s = "{\"Auth\":\"sxs\"}";
        JsonTest jsonTest = JSON.parseObject(s,JsonTest.class);
        System.out.println(JSON.toJSONString(jsonTest));
    }

    public static void calenderTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,-10);
        Date date = calendar.getTime();
        System.out.println(sdf.format(date));
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,30);
        date = calendar.getTime();
        System.out.println(sdf.format(date));
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-2);
        date = calendar.getTime();
        System.out.println(sdf.format(date));
    }

    public static void strIsNum(){
        String s = "s";
        String ss = "11";
        String sss = "11sd";
        System.out.println(s.chars().allMatch(Character::isDigit));
        System.out.println(ss.chars().allMatch(Character::isDigit));
        System.out.println(sss.chars().allMatch(Character::isDigit));
    }

    public static  void testArrayList(){
        test t = new test("1","2");
        t.setS1("1");
        t.setS2("2");
        List<test> l = new ArrayList<>();
        System.out.println(JSON.toJSONString(Collections.singletonList(t)));

    }

    public static void exceptionTest() {
        try {
            throw new NullPointerException();
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName());
        }
    }

    public static void mapTest(){
        Map<String,String> map = new HashMap<>();
        map.put("1","11");
        map = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue,Map.Entry::getKey));
        System.out.println(map.get("11"));
    }

    public static boolean isLastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,(calendar.get(Calendar.DATE) + 1));
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }

    public static boolean dateBefore(){
        String date = "20220131";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        boolean s = false;
        try {
            Date date1 = sdf.parse(date);
            calendar.setTime(date1);
            calendar.add(Calendar.DATE,30);
            date1 = calendar.getTime();
            s = date1.before(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return s;
    }

    public void apped(StringBuffer s){
        s.append("1");
    }

    static class Demo{
        public void apped(StringBuffer s){
            s.append("1");
        }

        public String appedS(String s){
            s = s + "1";
            return s;
        }
    }

    public static void listTest(){
        String s = "1";
        List<String> sq = Collections.singletonList(s);
        for (String s1: sq){
            System.out.println(s1);
        }
    }

    public static void listTestLamda(){
        List<test> list = new ArrayList<>();
        list.add(new test("1","11"));
        list.add(new test("2","22"));
        List<String> stringList = list.stream().filter(a->"2".equals(a.getS1()))
                .map(test::getS2).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(stringList));
    }

    static class test{
        private String s1;
        private String s2;

        public test(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public String getS2() {
            return s2;
        }

        public void setS2(String s2) {
            this.s2 = s2;
        }
    }

    static class JsonTest{

        @JSONField(name = "Auth")
        private String auth;

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }
    }
}
