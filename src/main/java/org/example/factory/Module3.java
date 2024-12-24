package org.example.factory;

import java.util.HashMap;

class Module3 extends AbstractModule<HashMap<String, String>> {
    //필드
    private HashMap<String, String> map;

    //생성자
    public Module3(HashMap<String, String> map) {
        this.map = map;
    }

    // abstrack class implement Map -> Map
    @Override
    public HashMap<String, HashMap<String, String>> collect() {
        HashMap<String, HashMap<String, String>> map = createMap();
        map.put("Module3", this.map);
        return map;
    }
}