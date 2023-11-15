package test.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzy
 * @time 2023/2/27 15:40
 */

public class TestImpl implements TestClientInterface{

    @Override
    public List<TestBodyEnity> productClientMsg(String s) {
        List<TestBodyEnity> list = new ArrayList<>();
        for (int i =0;i<=10;i++){
            TestBodyEnity testBodyEnity = new TestBodyEnity();
            testBodyEnity.setA(i);
            list.add(testBodyEnity);
        }
        return list;
    }
}
