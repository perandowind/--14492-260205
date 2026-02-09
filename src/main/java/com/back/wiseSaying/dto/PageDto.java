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

}
