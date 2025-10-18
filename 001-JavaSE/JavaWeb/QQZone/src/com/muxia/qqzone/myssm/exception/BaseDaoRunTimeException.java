package com.muxia.qqzone.myssm.exception;

/*
* 封装一个异常
* */
public class BaseDaoRunTimeException extends RuntimeException{
    public BaseDaoRunTimeException(String msg){
        super(msg);
    }
}
