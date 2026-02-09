package com.back.wiseSaying.repository;

import com.back.wiseSaying.dto.PageDto;
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

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public PageDto findListDesc(int page, int pageSize) {

        int totalCount = wiseSayings.size();

        List<WiseSaying> content = wiseSayings.reversed()
                .stream()
                .skip((long) (page - 1) * pageSize)
                .limit(pageSize)
                .toList();//참고: 스트림에선 reversed() 동작X

        return new PageDto(page, pageSize, totalCount, content);
    }

    public PageDto findByContentKeywordOrderByDesc(String keyword, int page, int pageSize) {

        int totalCount = wiseSayings
                .stream()
                .filter(w -> w.getSaying().contains(keyword))
                .toList().size();

        List<WiseSaying> content = wiseSayings.reversed()
                .stream()
                .skip((long) (page - 1) * pageSize) //skip(0) 처음부터 pageSize개 가져옴
                .filter(w -> w.getSaying().contains(keyword))
                .limit(pageSize)
                .toList();

        return new PageDto(page, pageSize, totalCount, content);
    }

    public PageDto findByAuthorKeywordOrderByDesc(String keyword, int page, int pageSize) {

        int totalCount = wiseSayings
                .stream()
                .filter(w -> w.getAuthor().contains(keyword))
                .toList().size();

        List<WiseSaying> content = wiseSayings.reversed()
                .stream()
                .skip((long) (page - 1) * pageSize)
                .filter(w -> w.getAuthor().contains(keyword))
                .limit(pageSize)
                .toList();

        return new PageDto(page, pageSize, totalCount, content);
    }
}