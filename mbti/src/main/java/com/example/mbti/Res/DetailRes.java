package com.example.mbti.Res;

import com.example.mbti.Dto.FindDetailDto;
import com.example.mbti.Dto.FindJobsDto;
import com.example.mbti.Req.PostReq;
import com.example.mbti.Validation.ExceptionCode;
import lombok.Getter;

import java.util.List;

@Getter
public class DetailRes extends ResponseJob{
    private FindDetailDto findDetailDto;

    public DetailRes(ExceptionCode exceptionCode, FindDetailDto findDetailDto) {
        super(exceptionCode);
        this.findDetailDto = findDetailDto;
    }
}
