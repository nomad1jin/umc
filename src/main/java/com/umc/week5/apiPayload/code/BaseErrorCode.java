package com.umc.week5.apiPayload.code;


public interface BaseErrorCode {

    ErrorReasonDto getReason();
    ErrorReasonDto getReasonHttpStatus();
}
