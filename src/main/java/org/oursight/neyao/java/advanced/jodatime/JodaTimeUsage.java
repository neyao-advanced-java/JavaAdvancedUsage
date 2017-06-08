package org.oursight.neyao.java.advanced.jodatime;

import org.joda.time.DateTime;
import org.oursight.neyao.java.advanced.util.DateUtil;

/**
 * Created by neyao on 2017/5/31.
 */
public class JodaTimeUsage {

    public static void main(String[] args) {
        getYesterday();
    }

    public static void getYesterday() {
        DateTime dateTime = new DateTime();
        DateTime yesterday = dateTime.minusDays(1);
        System.out.println(yesterday.toDate());
        System.out.println(DateUtil.timeMillisToString(yesterday.getMillis()));

    }

    public static void basic() {
        long timeMillis1 = DateTime.parse("2017-05-01").toDate().getTime();
        long timeMillis2 = DateTime.parse("20170501").toDate().getTime();

        System.out.println("timeMillis1: " + timeMillis1);
        System.out.println("timeMillis2: " + timeMillis2);

        System.out.println(DateUtil.timeMillisToString(timeMillis1));
        System.out.println(DateUtil.timeMillisToString(timeMillis2));
    }

}
