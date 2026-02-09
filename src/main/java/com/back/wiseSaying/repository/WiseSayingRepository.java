package com.back.wiseSaying.repository;

import com.back.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed()
                .stream()
                .limit(5)
                .toList(); //참고: 스트림에선 reversed() 동작X


    }

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> findByContentKeywordOrderByDesc(String keyword) {
        return wiseSayings.reversed()
                .stream()
                .filter(w -> w.getSaying().contains(keyword))
                .limit(5)
                .toList();
    }

    public List<WiseSaying> findByAuthorKeywordOrderByDesc(String keyword) {
        return wiseSayings.reversed()
                .stream()
                .filter(w -> w.getAuthor().contains(keyword))
                .limit(5)
                .toList();
    }
}