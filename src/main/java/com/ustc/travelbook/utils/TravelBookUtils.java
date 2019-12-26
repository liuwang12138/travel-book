package com.ustc.travelbook.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ustc.travelbook.dao.FlightDao;
import com.ustc.travelbook.po.FlightPO;
import com.ustc.travelbook.po.ReservationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author shanjizhong
 * @date 2019/12/26 11:21
 */
@Component
public class TravelBookUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMssHHmmss");

    private static Random random = new Random();

    public static synchronized String generateRandomKey() {
        return sdf.format(new Date()) + generateFourRandomNum();
    }

    private static int generateFourRandomNum() {
        return random.nextInt(9000) + 1000;
    }

    public static String encryptWithMd5(String str) throws Exception {
        String result = "";
        if(str == null) {
            str = "";
        }

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((str).getBytes(StandardCharsets.UTF_8));
        byte[] b = md5.digest();

        int i;
        StringBuilder buf = new StringBuilder();

        for (byte value : b) {
            i = value;
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        result = buf.toString().toUpperCase();

        return result;
    }

}
