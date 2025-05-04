package com.umc.week5.week7;

import com.umc.week5.apiPayload.code.BaseErrorCode;
import com.umc.week5.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
