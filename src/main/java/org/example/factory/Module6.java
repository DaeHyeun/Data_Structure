package org.example.factory;

import java.util.HashMap;
import java.util.Stack;

public class Module6 extends AbstractModule<Stack<String>>{

    private Stack<String> stringStack;

    public Module6(Stack<String> stringStack){
        this.stringStack = stringStack;
    }

    @Override
    public HashMap<String, Stack<String>> collect() {
        //HashMAp에 Stack<String>을 저장하여 반환
        HashMap<String, Stack<String>> map = createMap();
        map.put("Stack Data", stringStack);
        return map;
    }
}
