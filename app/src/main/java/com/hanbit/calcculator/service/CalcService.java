package com.hanbit.calcculator.service;

import com.hanbit.calcculator.domain.CalcDTO;

/**
 * Created by hb2003 on 2016-12-10.
 */

public interface CalcService {
    /*abstract은 추상메소드로 interface클래스에서는 생략 가능*/
    public abstract int plus(CalcDTO param);
    public abstract int minus(CalcDTO param);
    public abstract int multi(CalcDTO param);
    public abstract int divide(CalcDTO param);
}
