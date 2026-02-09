package com.back.wiseSaying.dto;

import com.back.wiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor //모든 인자를 포함하는 생성자 생성
public class PageDto {

    private int page;
    private int pageSize;
    private int totalCount;
    private List<WiseSaying> content;

    /**Dto는 값을 바꾸는 것을 넣지 않는데, 아래 메서드는 값을 바꾸지않아서 사용가능*/
    public int getPageCount() {
        return (int) Math.ceil((double)totalCount / pageSize); //ceil -> 올림처리
    }

}
