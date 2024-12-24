package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;


class Module2 extends AbstractModule<HashMap<String, Integer>> {
    //field
    private HashMap<String, Integer> map;

    public Module2 (HashMap<String, Integer> parameter){
        this.map = parameter;
    }

    // abstrack class implement Map -> Map
    @Override
    public HashMap<String, HashMap<String, Integer>> collect() {
        HashMap<String, HashMap<String, Integer>> map = createMap();
        map.put("Module2", this.map);
        return map;
    }
}