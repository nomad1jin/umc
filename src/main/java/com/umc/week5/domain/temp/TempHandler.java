package com.umc.week5.domain.temp;

import com.umc.week5.global.apiPayload.code.BaseErrorCode;
import com.umc.week5.global.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
