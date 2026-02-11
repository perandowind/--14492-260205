package com.back.wiseSaying.service;

import com.back.global.AppContext;
import com.back.wiseSaying.dto.PageDto;
import com.back.wiseSaying.entity.WiseSaying;
import com.back.wiseSaying.repository.WiseSayingRepository;

import java.util.Optional;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public boolean delete(int id) {
        Optional<WiseSaying> wiseSayingOp = wiseSayingRepository.findById(id);
        if (wiseSayingOp.isEmpty()) {
            return false;
        }
        return wiseSayingRepository.delete(wiseSayingOp.get());
    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {

        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }

    public PageDto findListDesc(String keyword, String keywordType, int page, int pageSize) {
        return switch (keywordType) {
            case "content" -> wiseSayingRepository.findByContentContainingDesc(keyword, page, pageSize);
            case "author" -> wiseSayingRepository.findByAuthorContainingDesc(keyword, page, pageSize);
            default -> wiseSayingRepository.findAll(page, pageSize); //둘 다 아니면, 전체검색
        };
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findById(id).orElse(null);
    }

}