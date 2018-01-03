package cn.nxnil.blueack.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CommonUtils {

    public static String getHostName() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String hostname = address.getHostName();
            return hostname;
        } catch (UnknownHostException ex) {
            return "";
        }
    }


    public static BigDecimal stringToBigDecimal(String str) {
        if (StringUtils.isEmpty(str))
            return null;
        return new BigDecimal(str);
    }

//    public static void main(String[] args) {
//        String a = "1.99";
//        System.out.println(NumberUtils.createBigDecimal(a));
//
//    }

    public static BigDecimal toRounding(BigDecimal b) {
        if (b == null)
            return null;
        return b.setScale(6, RoundingMode.HALF_UP);
    }


}
