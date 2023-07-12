package com.example.mbti.Res;

import com.example.mbti.Domain.Mbti;
import lombok.Getter;

@Getter
public class MbtiRes {
    private String mbti;
    private String info;

    public MbtiRes(Mbti mbti){
        this.mbti = mbti.getMbtiw();
        this.info = mbti.getInfo();
    }
}
