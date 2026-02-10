package com.back.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode //단순 주소값 비교가 아니라 객체 값을 비교한다.
public class WiseSaying {
    private int id;
    private String saying;
    private String author;

    public boolean isNew() {
        return id == 0;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> map = new LinkedHashMap<>(); //순서 보장
        map.put("id", id);
        map.put("saying", saying);
        map.put("author", author);

        return map;
    }

    public static WiseSaying fromMap(Map<String, Object> map){
        int id = (int) map.get("id");
        String saying = (String) map.get("saying");
        String author = (String) map.get("author");

        return new WiseSaying(id,saying,author);
    }


}
