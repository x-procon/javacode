package cc.procon.util;


import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 时间工具类
 * @author Procon
 */
public class ProconDateUtil {

    
    private ProconDateUtil(){}
    
    /**
     * 获取两个日期相差的月份
     * @param d1 日期1
     * @param d2 日期2
     * @return 日期1和日期二的差值
     */
    public static int getMonthDiff(Date d1, Date d2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()){
            return 0;
        }
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        boolean result = (month1 == month2) && (day1 < day2);
        if((month1 < month2) || result) {
            yearInterval --;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2 ;
        if(day1 < day2) {
            monthInterval --;
        }
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;

    }


    /**
     * 获取两个日期相差的周数
     * @param big 大的日期
     * @param small 小的日期
     * @return 相差的周数
     */
    public static int getTwoDatesDifOfWeek(Date big,Date small) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(big);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(small);
        //跨年
        if (cal1.get(Calendar.MONTH) != Calendar.DECEMBER && cal2.get(Calendar.MONTH) == Calendar.DECEMBER) {
            Calendar cal3 = Calendar.getInstance();
            cal3.set(Calendar.MONTH, 11);
            cal3.set(Calendar.DAY_OF_MONTH, 31);
            return cal3.get(Calendar.WEEK_OF_YEAR) - cal2.get(Calendar.WEEK_OF_YEAR) + cal1.get(Calendar.WEEK_OF_YEAR);
        } else {
            return cal1.get(Calendar.WEEK_OF_YEAR) - cal2.get(Calendar.WEEK_OF_YEAR);
        }
    }

}
