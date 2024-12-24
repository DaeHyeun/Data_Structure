package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;

class Module3 extends AbstractModule<HashMap<String, String>> {
    //필드
    private HashMap<String, String> map;

    public Module3 (HashMap<String, String> parameter){
        this.map = parameter;
    }


    // abstrack class implement Map -> Map
    @Override
    public HashMap<String, HashMap<String, String>> collect() {
        HashMap<String, HashMap<String, String>> map = createMap();
        map.put("Module3", this.map);
        return map;
    }
}