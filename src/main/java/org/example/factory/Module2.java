package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
class Module2 extends AbstractModule<HashMap<String, Integer>> {
    //field
    private HashMap<String, Integer> map;

    // abstrack class implement Map -> Map
    @Override
    public HashMap<String, HashMap<String, Integer>> collect() {
        HashMap<String, HashMap<String, Integer>> map = createMap();
        map.put("Module2", this.map);
        return map;
    }
}