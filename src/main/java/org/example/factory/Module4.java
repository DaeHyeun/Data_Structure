package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Module4 extends AbstractModule<Set<String>> {

    private Set<String> stringSet; // Set<String> 타입의 필드

    public Module4 (Set<String> parameter){
        this.stringSet = parameter;
    }


    @Override
    public HashMap<String, Set<String>> collect() {
        // HashMap에 Set<String>을 저장하여 반환
        HashMap<String, Set<String>> map = createMap();
        map.put("SetData", stringSet);
        return map;
    }
}