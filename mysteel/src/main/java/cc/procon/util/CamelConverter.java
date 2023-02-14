package cc.procon.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.sql.Clob;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName CamelConverter.java
 * @Description TODO
 * @createTime 2022年04月14日 16:00
 */
@Slf4j
public class CamelConverter {
    private CamelConverter() {
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");


    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     * user_name  ---->  userName
     * userName   --->  userName
     *
     * @param underlineStr 带有下划线的字符串
     * @return 驼峰字符串
     */
    public static String lineToHumpOpt(String underlineStr) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (underlineStr == null || underlineStr.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!underlineStr.contains("_")) {
            // 不含下划线，仅将首字母小写
            return underlineStr.substring(0, 1).toLowerCase() + underlineStr.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = underlineStr.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
     */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线,效率比上面高
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    public static JSONObject convert(JSONObject jsonObject) {
        JSONObject newJsonObject = new JSONObject();
        if (null != jsonObject) {
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String upKey = entry.getKey();
                if (entry.getValue() instanceof Clob) {
                    String clobToString = null;
                    try {
                        clobToString = JsonUtils.clobToString((Clob) entry.getValue());
                    } catch (Exception e) {
                        log.error("convert数据clob格式化转化异常:"+entry.getValue(), e);
                    }
                    newJsonObject.put(CamelConverter.lineToHump(upKey), clobToString);
                }else{
                    newJsonObject.put(CamelConverter.lineToHump(upKey), entry.getValue());
                }
            }
        }
        return newJsonObject;
    }
}
