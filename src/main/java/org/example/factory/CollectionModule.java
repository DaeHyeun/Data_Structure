package org.example.factory;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
class CollectionModule implements Collection<Object>  {
    private Module1 module1;
    private Module2 module2;
    private Module3 module3;
    private Module4 module4;  // Module4 추가
    private Module5 module5;
    private Module6 module6;


    @Override
    public HashMap<String, Object> collect() {
        HashMap<String, Object> combinedMap = new HashMap<>();
        combinedMap.putAll(module1.collect());
        combinedMap.putAll(module2.collect());
        combinedMap.putAll(module3.collect());
        combinedMap.putAll(module4.collect());  // module4 데이터 추가
        combinedMap.putAll(module5.collect());
        combinedMap.putAll(module6.collect());
        return combinedMap;
    }
}