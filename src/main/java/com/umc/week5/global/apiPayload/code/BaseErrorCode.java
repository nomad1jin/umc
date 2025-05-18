package com.umc.week5.global.apiPayload.code;


public interface BaseErrorCode {

    ErrorReasonDto getReason();
    ErrorReasonDto getReasonHttpStatus();
}
