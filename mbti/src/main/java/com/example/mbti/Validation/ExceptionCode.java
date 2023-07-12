package com.example.mbti.Validation;

import lombok.Getter;

import java.util.Arrays;

import static com.example.mbti.Validation.HttpStatus.NOT_FOUND_VALUE;
import static com.example.mbti.Validation.HttpStatus.SUCCESS;


public enum ExceptionCode {
    JOBS_RETURN(SUCCESS, "0000", "채용 공고 리스트 반환 성공"),
    JOBS_NOT_FOUND(NOT_FOUND_VALUE, "0001", "채용 공고 리스트 반환 실패"),
    DETAIL_RETUN(SUCCESS, "0002", "채용 공고 디테일 반환 성공"),
    DETAIL_NOT_FOUND(NOT_FOUND_VALUE, "0003", "채용 공고 디테일 반환 실패"),
    COVER_LETTER_RETUN(SUCCESS, "0004", "지원서 작성 완료"),
    COVER_LETTER_NOT_CREATE(NOT_FOUND_VALUE, "0005", "지원서 작성 실패");

    private final HttpStatus status;
    private final String code;
    private final String message;
    ExceptionCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
