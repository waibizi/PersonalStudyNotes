package com.waibizi.demo04;

/**
 * @Author 吴典秋
 * @Date 2020/6/2 8:11
 * @Description:
 * @Version 1.0
 */

public interface CusInfoValidator{
    public abstract boolean isValidName(String name);
    public abstract boolean isValidAddress(String address);
    public abstract boolean isValidZipCode(String zipCode);
    public abstract boolean isValidCellPhoneNum(String phoneNum);
    public abstract boolean isValidSSNNum(String SSNNum);
    public abstract boolean isValidEmail(String email);
}

