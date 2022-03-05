package com.mvc.kgdemo.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_DATEDETAIL_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

    public static final String DATE8_PATTERN = "yyyyMMdd";

    public static final String DATE10_PATTERN = "yyyy-MM-dd";

    public static final String TIME6_PATTERN = "HHmmss";

    public static final String TIME8_PATTERN = "HH:mm:ss";

    public static final String DATETIME14_PATTERN = "yyyyMMddHHmmss";

    public static final String DATETIME19_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATEMSEL17_PATTERN = "yyyyMMddHHmmssSSS";

    public static final String DATEMSEL18_PATTERN = "yyyyMMddHHmmssSSSS";

    public static Date DefaultDate = null;

    public static SimpleDateFormat format12Str = new SimpleDateFormat("yyyy年MM月dd日HH:mm");

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前月的第一天字符串
     *
     * @return yyyy-MM-dd
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);

        return format.format(c.getTime());
    }

    /**
     * 获取当前天字符串
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 获取当前天字符串
     *
     * @return yyyyMMdd
     */
    public static String getCurrentDayyyyMMdd() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * 获取当前天字符串
     *
     * @return yyyyMMddHHmmss
     */
    public static String getCurrentDayyyyMMddHHmmss() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }



    /**
     * 获取当前天字符串
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentDayyyyy_MM_dd() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 获取当前年月
     *
     * @return
     */
    public static String getCurrentYYYMM() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMM");
        return format.format(date);
    }

    /**
     * 获取当前天字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDayyyyy_MM_dd_HH_mm_ss() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 获取当前天后15天字符串
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentDayAdd15yyyy_MM_dd() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 15);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());
    }

    /**
     * 获取当前天后1天字符串
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentDayAdd1yyyyMMdd() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());
    }

    /**
     * 获取当前天前1天字符串
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentDaysub1yyyy_MM_dd() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());
    }

    /**
     * 获取当前天前1个月字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentMonthsub1yyyy_MM_dd() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        ;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(c.getTime());
    }

    /**
     * 获取当前天前1周字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDaysub7yyyy_MM_dd() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -7);
        ;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(c.getTime());
    }

    /**
     * 获取当前月的前一个月的第一天
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentMonthFistdayyyyy_MM_dd() {
        Calendar cmfd = Calendar.getInstance();
        cmfd.add(Calendar.MONTH, -1);
        cmfd.set(Calendar.DAY_OF_MONTH, 1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cmfd.getTime());
    }

    /**
     * 获取当前月的前一个月的最后一天
     *
     * @return yyyy-MM-dd
     */
    public static String getCurrentMonthLastdayyyyy_MM_dd() {
        Calendar cmld = Calendar.getInstance();
        cmld.add(Calendar.MONTH, -1);
        cmld.set(Calendar.DAY_OF_MONTH, 30);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cmld.getTime());
    }


    /**
     * @param date1
     * @param date2
     * @return 1, date1>date2;-1,date1<date2;0,date1=date2
     */
    public static int compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if (!("".equals(date1) || "".equals(date2))) {
                Date dt1 = df.parse(date1);
                Date dt2 = df.parse(date2);
                return Long.compare(dt1.getTime(), dt2.getTime());
            } else if (!"".equals(date1)) {
                return 1;
            } else if (!"".equals(date2)) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDayofMonth(String period) {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMM");

        try {
            rightNow.setTime(simpleDate.parse(period));
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return period + rightNow.getActualMaximum(5);
    }

    /**
     * 字符串转换成日期格式化
     *
     * @param str
     * @param formatStr
     * @return date
     */
    public static Date StrToDate(String str, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转换成字符串
     *
     * @param formatStr
     * @return date
     */
    public static String DateToStr(Date date, String formatStr) {
        DateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    /**
     * 格式为:yyyy-MM-dd hh:mm的当前日期的字符串 转为yyyyMMddHHmmss
     *
     * @return
     */
    public static String changeDate(String date) {
        date = date.replaceAll("[[\\s-:punct:]]", "");
        return date;
    }

    /**
     * 获取当前时间前几分钟时间字符串
     *
     * @param minutes 分钟
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDayAddMinutesDate(int minutes) {
        Calendar nowBefore = Calendar.getInstance();
        nowBefore.add(Calendar.MINUTE, minutes);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(nowBefore.getTimeInMillis());
    }

    /**
     * 获取当前天前number个月字符串
     *
     * @return yyyyMMdd
     */
    public static String getCurrentMonthSubNumyyyy_MM_dd(int number) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, number);
        ;
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(c.getTime());
    }

    /**
     * long时间差换算时分秒
     *
     * @return *天*小时*分*秒*毫秒
     */
    public static String getLongToTime(Long longTime) {
        long day = longTime / (24 * 60 * 60 * 1000);
        long hour = (longTime / (60 * 60 * 1000) - day * 24);
        long min = ((longTime / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (longTime / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long timeSpan = longTime % 1000;
        return day + "天" + hour + "小时" + min + "分" + s + "秒" + timeSpan + "毫秒";
    }

    public static Date getDay() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return date;
    }

    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static Date curDate() {
        return new Date();
    }

    public static String curDateStr(String strFormat) {
        Date date = new Date();
        return getDateParser(strFormat).format(date);
    }

    public static String curDateStr() {
        Date date = new Date();
        return getDateParser(DEFAULT_DATE_PATTERN).format(date);
    }

    public static Timestamp curTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static Date toDate(String dateString, String pattern) {
        Date date = null;
        try {
            date = getDateParser(pattern).parse(dateString);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Date toDate(String dateString) {
        Date date = null;
        try {
            date = getDateParser(DEFAULT_DATE_PATTERN).parse(dateString);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Date toDateTime(String dateString) {
        Date date = null;
        try {
            date = getDateParser(DEFAULT_DATETIME_PATTERN).parse(dateString);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static String toDateStr(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        return getDateParser(pattern).format(date);
    }

    public static String toDateStr(Date date) {
        if (date == null) {
            return "";
        }
        return getDateParser(DEFAULT_DATE_PATTERN).format(date);
    }

    public static String toDateTimeStr(Date date) {
        if (date == null) {
            return "";
        }
        return getDateParser(DEFAULT_DATETIME_PATTERN).format(date);
    }

    public static String curDateStr8() {
        Date date = new Date();
        return getDateParser(DATE8_PATTERN).format(date);
    }

    public static String curDateStr10() {
        Date date = new Date();
        return getDateParser(DATE10_PATTERN).format(date);
    }

    public static String curDateTimeStr14() {
        Date date = new Date();
        return getDateParser(DATETIME14_PATTERN).format(date);
    }

    public static String curDateTimeStr19() {
        Date date = new Date();
        return getDateParser(DATETIME19_PATTERN).format(date);
    }

    public static String curTimeStr6() {
        Date date = new Date();
        return getDateParser(TIME6_PATTERN).format(date);
    }

    public static String curDateMselStr17() {
        Date date = new Date();
        return getDateParser(DATEMSEL17_PATTERN).format(date);
    }

    public static String curDateMselStr18() {
        Date date = new Date();
        return getDateParser(DATEMSEL18_PATTERN).format(date);
    }


    public static Date toDate8(String dateStr) {
        Date date = null;
        try {
            date = getDateParser(DATE8_PATTERN).parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Date toDate10(String dateStr) {
        Date date = null;
        try {
            date = getDateParser(DATE10_PATTERN).parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Date toDateTime14(String dateStr) {
        Date date = null;
        try {
            date = getDateParser(DATETIME14_PATTERN).parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Date toDateTime19(String dateStr) {
        Date date = null;
        try {
            date = getDateParser(DATETIME19_PATTERN).parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static String toDateStr8(Date date) {
        if (date == null) {
            return "";
        }
        return getDateParser(DATE8_PATTERN).format(date);
    }

    public static String toDateStr10(Date date) {
        if (date == null) {
            return "";
        }
        return getDateParser(DATE10_PATTERN).format(date);
    }

    public static String toDateTimeStr14(Date date) {
        if (date == null) {
            return "";
        }
        return getDateParser(DATETIME14_PATTERN).format(date);
    }

    public static String toDateTimeStr19(Date date) {
        if (date == null) {
            return "";
        }
        return getDateParser(DATETIME19_PATTERN).format(date);
    }

    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static boolean isDateBetween(Date date, Date date1, Date date2) {
        return (date1.before(date) || date1.equals(date))
                && (date.before(date2) || date.equals(date2));
    }

    public static int getDaysInterval(Date fromDate, Date toDate) {
        if (fromDate == null || toDate == null) {
            return 0;
        }
        long timeInterval = toDate.getTime() - fromDate.getTime();
        int daysInterval = (int) (timeInterval / (24 * 3600 * 1000));
        return daysInterval;
    }

    public static int getWeekOfYear(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        return week;
    }

    public static int getDayOfWeek(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        day -= 1;
        if (0 == day) {
            day = 7;
        }
        return day;
    }

    public static Date getLastDayInMonth(Date date) {
        return getLastDayInMonth(date, 0);
    }

    public static Date getLastDayInNextMonth(Date date) {
        return getLastDayInMonth(date, 1);
    }

    public static Date getLastDayInMonth(Date date, int i) {
        if (date == null) {
            return null;
        }

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i + 1);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static String toDateTime(long times) {
        times = times / 1000;
        long hours, minutes, seconds;
        hours = times / 3600;
        times = times - (hours * 3600);
        minutes = times / 60;
        times = times - (minutes * 60);
        seconds = times;
        String result = hours + "(h) " + minutes + "(m) " + seconds + "(s)";
        return result;
    }


    public static String dateDiff(String startTime, String endTime, String format) throws Exception {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
        return dateDiff(diff);
    }

    public static String dateDiff(String startTime, String endTime) throws Exception {
        return dateDiff(startTime, endTime, "yyyyMMddHHmmss");
    }

    public static String dateDiff(String startTime) throws Exception {
        return dateDiff(startTime, curDateTimeStr14(), "yyyyMMddHHmmss");
    }

    public static String dateDiff(Date startTime, Date endTime) {
        long diff = endTime.getTime() - startTime.getTime();

        return dateDiff(diff);
    }

    public static String dateDiff(long millisecond) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        long day = millisecond / nd;
        long hour = millisecond % nd / nh;
        long min = millisecond % nd % nh / nm;
        long sec = millisecond % nd % nh % nm / ns;
        String ret = "";
        if (sec > 0) {
            ret = sec + ":";
        }
        ret = min + ":" + ret;
        if (hour > 0) {
            ret = hour + ":" + ret;
        }
        if (day > 0) {
            ret = day + ":" + ret;
        }
        return ret;
    }

    /**
     * 返回当前日期yyyy年MM月dd日HH:mm
     *
     * @return 日期
     */
    public static String getFormatDate12Str() {
        String dateStr = format12Str.format(new Date());
        String month = dateStr.substring(5, 7);
        dateStr = dateStr.replace(month + "月", getNumberMonth(month) + "月");
        return dateStr;
    }

    public static String getNumberMonth(String month) {
        String mon = CommonSolveUtils.nullToString(month);
        if (mon.length() == 0) {
            return "";
        } else if (mon.indexOf("0") == 0) {
            return mon.substring(1, 2);
        } else {
            return mon;
        }
    }

    /**
     * This method converts a String to a date using the datePattern
     *
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate)
            throws ParseException {
        Date aDate = null;

        try {
            aDate = convertStringToDate(DATE8_PATTERN, strDate);
        } catch (ParseException pe) {
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());

        }

        return aDate;
    }

    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     *
     * @param aMask   the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @throws ParseException
     * @see SimpleDateFormat
     */
    public static final Date convertStringToDate(String aMask, String strDate)
            throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }
}
