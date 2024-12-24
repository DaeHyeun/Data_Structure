package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Stack;

@AllArgsConstructor
public class Module6 extends AbstractModule<Stack<String>>{

    private Stack<String> stringStack;


    @Override
    public HashMap<String, Stack<String>> collect() {
        //HashMAp에 Stack<String>을 저장하여 반환
        HashMap<String, Stack<String>> map = createMap();
        map.put("Stack Data", stringStack);
        return map;
    }
}
