package org.example.self;

import java.util.*;

public class CharFrequeny {
    public static void main(String[] args) {

        String str = "hi, my name is donghee. nice to meet you";
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c),1) + 1);
        }

        List<String> stringList = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            stringList.add(entry.getKey());
            integers.add(entry.getValue());
        }

        System.out.println("map : " + map.toString());
        System.out.println("intList : " +integers.toString());
        System.out.println("strList : " + stringList.toString());

        int tempint = 0;
        String tempString = "";

        for (int i = 0; i < stringList.size()-1; i++) {
            for (int j = i+1; j < stringList.size(); j++) {
                if(integers.get(i) < integers.get(j)){
                    tempint = integers.get(i);
                    integers.set(i,integers.get(j));
                    integers.set(j,tempint);

                    tempString = stringList.get(i);
                    stringList.set(i,stringList.get(j));
                    stringList.set(j, tempString);
                } else if ((int) integers.get(i) == (int) integers.get(j)) {
                    if((stringList.get(i)).charAt(0) > (stringList.get(j)).charAt(0)){
                        tempint = integers.get(i);
                        integers.set(i,integers.get(j));
                        integers.set(j,tempint);

                        tempString = stringList.get(i);
                        stringList.set(i,stringList.get(j));
                        stringList.set(j, tempString);
                    }
                }

            }
        }

        System.out.println("가장 빈도 높은 문자부터 출력!!(공백제외)");
        for (String st : stringList){
            if (!st.equals(" ")){
                System.out.println(st);
            }
        }


    }
}
