package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
class Module3 extends AbstractModule<HashMap<String, String>> {
    //필드
    private HashMap<String, String> map;


    // abstrack class implement Map -> Map
    @Override
    public HashMap<String, HashMap<String, String>> collect() {
        HashMap<String, HashMap<String, String>> map = createMap();
        map.put("Module3", this.map);
        return map;
    }
}