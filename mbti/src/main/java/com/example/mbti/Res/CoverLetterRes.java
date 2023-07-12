package com.example.mbti.Res;

import com.example.mbti.Dto.FindDetailDto;
import com.example.mbti.Req.PostReq;
import com.example.mbti.Validation.ExceptionCode;
import lombok.Getter;

@Getter
public class CoverLetterRes extends ResponseJob{

    private Long id;

    private String content;

    public CoverLetterRes(ExceptionCode exceptionCode, Long id, String content) {
        super(exceptionCode);
        this.id = id;
        this.content = content;
    }
}
