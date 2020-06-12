package com.waibizi.demo04;

/**
 * @Author 吴典秋
 * @Date 2020/6/2 8:11
 * @Description:
 * @Version 1.0
 */

class InformationAdapter extends InfoValidation implements CusInfoValidator{

    /*------------------------------------------*/
    /* The Social Security number is a 9-digit  */
    /* number in the format "AAA-GG-SSSS".      */
    /*------------------------------------------*/
    @Override
    public boolean isValidSSNNum(String SSNNum){
        boolean isValid=true;
        String ns = SSNNum.trim();
        String nStr = ns.replaceAll("\\s{1,}", "");
        int len = nStr.length();

        if ( (nStr.charAt(3) == '-') && (nStr.charAt(6) == '-') && (len==11) ) {
            for(int m=0; m<len; m++){
                if(  (m != 3) && (m !=6) && ( Character.isDigit(nStr.charAt(m))==false) ){
                    isValid=false;
                }
            }
            return isValid;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValidEmail(String email) {
        boolean isValid=true;
        String myemail = email.trim();
        String zhengze = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        if (!myemail.matches(zhengze)){
            return isValid;
        }
        return false;
    }
}