package test.interfaces;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author dzy
 * @time 2023/3/14 23:13
 */

public class TestList {

    static class Car{
        private String vin;

        private String orderNo;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

//        @JSONField(name = "VIN")
        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }
    }

    static class Veh{
        private String vin;

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        for (int i = 1;i<=10;i++){
//            list.add(String.valueOf(i));
//        }
//        int limit = list.size()/3+(list.size()%3 != 0 ? +1 : 0);
//        List<List<String>> lists = new ArrayList<>();
//        int startNo = 1;
//        List<String> tList = new ArrayList<>();
//        for (int i = 0;i<list.size();i++){
//            if (i < startNo*3){
//                tList.add(list.get(i));
//            }
//            if (i == startNo*3-1 || i == list.size()-1){
//                lists.add(new ArrayList<>(tList));
//                startNo++;
//                tList.clear();
//            }
//        }
        System.out.println(String.valueOf(UUID.randomUUID()).replace("-","").substring(0,32));
        System.out.println(new ArrayList<>());
        Car car = new Car();
        car.setVin("11111");
        car.setOrderNo("11111");
        String s = JSON.toJSONString(car, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(s);
        Veh veh = JSON.parseObject(s,Veh.class);
        System.out.println(JSON.toJSONString(veh, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));

        try {
            Car car1;
//            System.out.println(car1.getOrderNo());
            car1 = JSON.parseObject("{}",Car.class);
            System.out.println(car1.getOrderNo());
        }catch (NullPointerException e){
            System.out.println(1);
        }catch (Exception e){
            System.out.println(2);
        }
    }
}
