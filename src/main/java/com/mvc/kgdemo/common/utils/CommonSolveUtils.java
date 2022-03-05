package com.mvc.kgdemo.common.utils;


import com.mvc.kgdemo.common.response.ReqInfo;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用解决方式工具类
 *
 * @author luzemin
 * @description 通用解决方式工具类
 * @date 2020/12/2-9:45
 **/
public class CommonSolveUtils {

    private static SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat format12Str = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
    private static SimpleDateFormat format8Str = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat format8 = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat format6 = new SimpleDateFormat("yyyyMM");
    private static DecimalFormat df = new DecimalFormat("#,###,##0.00");
    private static BigDecimal nT = new BigDecimal(0.0000001);

    /**
     * 左侧补0，返回字符串
     *
     * @param l 长度
     * @param v 值
     * @return 补长后字符串
     */
    public static String getLpad(int l, int v) {
        return String.format("%0" + l + "d", v);
    }


    /**
     * 使用map集合替换字符串中${key}
     *
     * @param str           待替换字符串
     * @param substituteMap 替代品属性集合
     * @return 替换后字符串
     */
    public static String placeholderReplace(String str, Map<String, Object> substituteMap) {
        StringSubstitutor stringSubstitutor = new StringSubstitutor(substituteMap);
        return stringSubstitutor.replace(str);
    }

    /**
     * 将数据的精度取消，去掉尾数多余的0  检查发现方法有重复的
     *
     * @param s 传输参数
     * @return s
     */
    public static String trimEndZero(String s) {
        if (s != null)
            if (s.indexOf(".") > 0) {
                s = s.replaceAll("0+?$", "");// 去掉多余的0
                s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
            }
        return s;
    }

    /**
     * 把null转换为空格
     *
     * @param obj 参数
     * @return s
     */
    public static String nullToSpace(Object obj) {
        if (obj == null) {
            return " ";
        }
        String object = String.valueOf(obj).trim();
        if (object.length() > 0) {
            return object;
        } else {
            return " ";
        }
    }


    /**
     * 如果是""或是null返回false , 否则返回true
     *
     * @param obj 传输参数
     * @return string
     */
    public static boolean equString(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if ("".equals(String.valueOf(obj).trim())) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * 解决字符串对象null
     *
     * @param obj 参数
     * @return string
     */
    public static String nullToString(Object obj) {
        if (obj == null) {
            return "";
        }
        return String.valueOf(obj).trim();
    }

    public static String java2sqlName(String s) {
        if (s == null)
            return null;
        StringBuffer sqlBuffer = new StringBuffer(s.length() * 2);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                sqlBuffer.append('_');
            sqlBuffer.append(s.charAt(i));
        }

        return sqlBuffer.toString().toLowerCase();
    }

    /**
     * 解决字符串对象null
     *
     * @param obj
     * @return string
     */
    public static BigDecimal nullToBigDecimal(Object obj) {
        if (!equString(obj)) {
            return new BigDecimal(0);
        }
        return new BigDecimal(obj.toString());
    }

    /**
     * 返回年年年年月月日日时时分分秒秒的时间字符串
     *
     * @return String
     */
    public static String getFormatString14() {
        return format14.format(new Date());
    }

    /**
     * 返回年年年年月月日日日期字符串
     *
     * @return String
     */
    public static String getFormatString8() {
        return format8.format(new Date());
    }

    /**
     * 返回年年年年月月期字符串
     *
     * @return String
     */
    public static String getFormatString6() {
        return format6.format(new Date());
    }

    /**
     * 返回XXXX年MM月dd日字符串
     *
     * @return String
     */
    public static String getFormatString8Str() {
        return format8Str.format(new Date());
    }

    /**
     * 处理格式化的日期 比如 2010-04-12 处理之后的结果 20100412
     *
     * @param formatDate
     * @return
     */
    public static String getDateString(String formatDate) {
        String result = "";
        String[] dataParts = nullToString(formatDate).split("-");
        for (int i = 0; i < dataParts.length; i++) {
            result += dataParts[i];
        }
        return result;
    }

    /**
     * 格式化的日期 比如 20100412 处理之后的结果 2010-04-12
     *
     * @param formatDate
     * @return
     */
    public static String getDateFormat(String formatDate) {
        String result = "";
        String tempFormatDate = nullToString(formatDate);
        result = tempFormatDate.substring(0, 4) + "-" + tempFormatDate.substring(4, 6) + "-"
                + tempFormatDate.substring(6, 8);
        return result;
    }

    public static String getFormatDate12Str() {
        String dateStr = format12Str.format(new Date());
        String month = dateStr.substring(5, 7);
        dateStr = dateStr.replace(month + "月", getNumberMonth(month) + "月");
        return dateStr;
    }

    // 14位
    public static String getFormatDate12Str(String date) {
        String dateStr = date.substring(0, 4) + "年" + date.substring(4, 6) + "月" + date.substring(6, 8) + "日 "
                + date.substring(8, 10) + ":" + date.substring(10, 12);
        return dateStr;
    }

    public static String getNumberMonth(String month) {
        String mon = nullToString(month);
        if (mon.length() == 0) {
            return "";
        } else if (mon.indexOf("0") == 0) {
            return mon.substring(1, 2);
        } else {
            return mon;
        }
    }
    /**
     * 根据条件查询数据，将查询的数据放在EiInfo中(只是方便于填充数据到所指定的块中,支持分页,不支持排序,只是方便于多个块显示的时候,
     * 可以调用这个方法)
     *
     * @param inInfo
     *            含有inqu_status块的查询条件
     * @param objectName
     *            查询的数据放在块名为blockId的块中
     * @param sqlMap
     *            查询使用的sqlMap文件
     * @param entity
     *            查询操作的对像
     * @param isMain
     *            是否显示msg
     * @return
     */
    public static ReqInfo queryNormalInfo(ReqInfo inInfo, String objectName, String sqlMap, Object entity, boolean isMain) {
        String [] path=sqlMap.split("\\.");
        String beanName=path[0];
        String methodName=path[1];
        Object serviceBean = SpringUtils.getBean(beanName);
        Method method = ReflectionUtils.findMethod(serviceBean.getClass(), methodName, entity.getClass());
        assert method != null;
//        Objects.requireNonNull(ReflectionUtils.invokeMethod(method, serviceBean, entity),"");
        Object queryResult= ReflectionUtils.invokeMethod(method, serviceBean, entity);
        if(queryResult!=null){
            inInfo.addBlock(objectName,queryResult);
        }
        return inInfo;
    }
    public static ReqInfo queryNormalInfo(ReqInfo inInfo, String objectName, String sqlMap, Object entity) {
        return CommonSolveUtils.queryNormalInfo( inInfo,  objectName,  sqlMap,  entity, false);
    }

    /**
     * 获得当前格式化的日期 比如2010-04-12
     *
     * param formatDate
     * return
     */
    public String getDateFormat() {
        String result = "";
        String tempFormatDate = nullToString(getFormatString8());
        result = tempFormatDate.substring(0, 4) + "-" + tempFormatDate.substring(4, 6) + "-"
                + tempFormatDate.substring(6, 8);
        return result;
    }

    /**
     * 处理日期类型比如说20051101转换结果为2005-11-1,即有零的都去掉
     *
     * param date
     * return
     */
    public static String getFormatString(String date) {
        String resultDate = "";
        resultDate = date.substring(0, 4);
        String tempStrng = date.substring(4, 6);
        resultDate = resultDate + "-";
        if (tempStrng.indexOf('0') == 0) {
            resultDate = resultDate + tempStrng.substring(1, 2);
        } else {
            resultDate = resultDate + tempStrng.substring(0, 2);
        }
        resultDate = resultDate + "-";
        tempStrng = date.substring(6, 8);

        if (tempStrng.indexOf('0') == 0) {
            resultDate = resultDate + tempStrng.substring(1, 2);
        } else {
            resultDate = resultDate + tempStrng.substring(0, 2);
        }
        return resultDate;
    }

    /**
     * 处理月份 比如9以下就格式化成0X
     *
     * param date
     * return
     */
    public static String getFormatMonth(String month) {
        if (month.length() > 1) {
            return month;
        } else {
            return "0" + month;
        }
    }

    /**
     * 获取日期-天数
     *
     * @param subDay
     * @return
     */
    public static String getDaysSub(int subDay) {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE, subDay);
        return format8.format(cal.getTime());
    }

    /**
     * 获取日期+天数
     *
     * param subDay
     * return
     */

    public static String getDaysAdd(Date date,int addDays){
        String dateStr = " ";
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(cal.DATE, addDays);
            dateStr = format8.format(cal.getTime());
        } catch (Exception e) {
            dateStr = " ";
        }
        return dateStr;
    }

    public static String getBeforePeriod(String currentPeriod) {
        String beforePeriod = "";
        String month = currentPeriod.substring(4);
        if ("01".equals(month)) {
            beforePeriod = String.valueOf(Integer.parseInt(currentPeriod.substring(0, 4)) - 1) + "12";
        } else {
            beforePeriod = String.valueOf(Integer.parseInt(currentPeriod) - 1);
        }
        return beforePeriod;
    }

    public static String getAfterPeriod(String currentPeriod) {
        String afterPeriod = "";
        String month = currentPeriod.substring(4);
        if ("12".equals(month)) {
            afterPeriod = String.valueOf(Integer.parseInt(currentPeriod.substring(0, 4)) + 1) + "01";
        } else {
            afterPeriod = String.valueOf(Integer.parseInt(currentPeriod) + 1);
        }
        return afterPeriod;
    }

    /**
     * 获取两个日期所相差的天数
     *
     * param fDate
     * param oDate
     * return
     */
    public static int daysOfTwo(Date fDate, Date sDate) {
        Calendar aCalendar = Calendar.getInstance();
        Calendar bCalendar = Calendar.getInstance();
        int days = 0;
        aCalendar.setTime(fDate);
//		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
//		aCalendar.setTime(sDate);
//		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
//		return day2 - day1;		//Calendar.DAY_OF_YEAR受跨年影响，遇到跨年的情况日期差就不准了
        bCalendar.setTime(sDate);
        //用before判断不受跨年影响
        if(aCalendar.before(bCalendar)){
            while(aCalendar.before(bCalendar)){//fDate在sDate之前的情况
                days++;
                aCalendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }else{
            while(bCalendar.before(aCalendar)){//fDate在sDate之后的情况
                days--;
                aCalendar.add(Calendar.DAY_OF_YEAR, -1);
            }
        }
        return days;
    }

    public static String getWithoutZero(String tempString) {
        if (tempString.indexOf('0') == 0) {
            tempString = tempString.replace("0", "");
        }
        return tempString;
    }

    /**
     * 去掉数字后多余的0
     *
     * @param num
     * @return
     */
    public static String removeTailZero(BigDecimal num) {
        String sf = num.toString();
        Pattern p = Pattern.compile("\\.");
        Matcher matcher = p.matcher(sf);
        if (!matcher.find()) {
            return sf;
        }
        sf = sf.replaceAll("0+?$", "");// 去掉多余的0
        sf = sf.replaceAll("[.]$", "");// 如最后一位是.则去掉
        return sf;
    }

    /**
     * 获取这个月的最后一天
     *
     * param period
     *            会计期 eg:201011
     * return
     */
    public static String getDayofMonth(String period) {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMM");
        try {
            rightNow.setTime(simpleDate.parse(period));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return period + rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static String formatString(String formateExpr, Map mapValues, String[] arrayDesc) {
        for (int i = 0; i < arrayDesc.length - 1; i++) {
            formateExpr = formateExpr.replace(arrayDesc[i], mapValues.get(arrayDesc[i]).toString());
        }
        return formateExpr;
    }

    public static Date formatDate(String dateStr) {
        Date dateReturn = null;
        try {
            // 将-替换
            dateStr = dateStr.replace("-", "");
            dateReturn = format8.parse(dateStr.substring(0, 8));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return dateReturn;
    }

    public static String getBigDecimalFormat(BigDecimal number) {
        return df.format(number);
    }

    public static BigDecimal setScale(BigDecimal num, int scale) {
        return (num.add(nT)).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static String nullToZeroStr(Object obj) {
        if (obj == null) {
            return "0";
        }
        String object = String.valueOf(obj).trim();
        if (object.length() > 0) {
            return object;
        } else {
            return "0";
        }
    }

}
