package music.util;

public class PhoneCode {
    private String phone;
    private String code;

    private static int newcode;
    public static int getNewcode() {
        return newcode;
    }
    public static void setNewcode(){
        newcode = (int)(Math.random()*9999)+100;  //每次调用生成一次四位数的随机数
    }

    public String getCode(){
        setNewcode();
        String code = Integer.toString(getNewcode());
        return code;
    }
}
