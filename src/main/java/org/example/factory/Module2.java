package org.example.factory;

import java.util.HashMap;

class Module2 extends AbstractModule<HashMap<String, Integer>> {
    //field
    private HashMap<String, Integer> map;

    // constructor
    public Module2(HashMap<String, Integer> map) {
        this.map = map;
    }

    // abstrack class implement Map -> Map
    @Override
    public HashMap<String, HashMap<String, Integer>> collect() {
        HashMap<String, HashMap<String, Integer>> map = createMap();
        map.put("Module2", this.map);
        return map;
    }
}