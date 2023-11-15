package study.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dzy
 * @time 2023/10/19 16:54
 */

public class ListTest<T> {

    public static void main(String[] args) {
        ListTest listTest = new ListTest<>();
//        listTest.listTestTest(listTest);
        listTest.stringTest();
    }

    private void stringTest(){
        String s = "/opt/pdp/upload/123465446-15464654-15641651.xsls";
        List<String> ss =Arrays.asList(s.split("/"));
        System.out.println(JSON.toJSONString(ss));
        int sum = ss.size() -1;
        ss = ss.stream().map(String::toString).skip(sum).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(ss));
        List<String> t = Arrays.asList(ss.get(0).split("-"));
        System.out.println(JSON.toJSONString(t));
        StringBuffer ssss = new StringBuffer();
        t.forEach(ssss::append);
        System.out.println(JSON.toJSONString(ssss));
    }

    private void listTestTest(ListTest listTest){
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        List<List<String>> ss = new ArrayList<>();
        for (int i = 0; i < 10 ;i++){
            l.add(i);
        }
        List<String> s = l.stream().map(String::valueOf).collect(Collectors.toList());
        ll = listTest.listTest(l,10);
        ss = listTest.listTest(s,10);
        System.out.println(JSON.toJSONString(ll));
        System.out.println(JSON.toJSONString(ss));
    }

    public List<List<T>> listTest(List<T> l, int taskNu){
        List<List<T>> ll = new ArrayList<>();
        int limit = l.size()/2 + (l.size()%2 != 0 ? 1 : 0);
        Stream.iterate(0, n->n+1).limit(limit).forEach(i->
                ll.add(l.stream().skip((long) i *2).limit(2).collect(Collectors.toList())));
        return ll;
    }
}
