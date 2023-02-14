package cc.procon.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

/**
 * @author: YangHui
 * @create: 2018-04-24 17:20
 **/
public class JsonUtils {

    private static final String JSON_PARSE_ERROR = "json解析出错：{}";

    private JsonUtils() {
    }

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：{}" + obj, e);
            return null;
        }
    }

    /**
     * Clob类型 转String
     *
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public static String clobToString(Clob clob) throws SQLException, IOException {
        String reString = "";
        // 得到流
        Reader is = clob.getCharacterStream();
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        // 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
        while (s != null) {
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString();
        if (br != null) {
            br.close();
        }
        if (is != null) {
            is.close();
        }
        return reString;
    }

    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error(JSON_PARSE_ERROR, json, e);
            return null;
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error(JSON_PARSE_ERROR, json, e);
            return Collections.emptyList();
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error(JSON_PARSE_ERROR, json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error(JSON_PARSE_ERROR, json, e);
            return null;
        }
    }

    /**
     * removeAll方法改造
     *
     * @param source
     * @param destination
     * @return
     */
    public static <T> List<T> removeAllReform(List<T> source, List<T> destination) {
        List<T> result = new LinkedList<T>();
        Set<T> destinationSet = new HashSet<T>(destination);
        for (T t : source) {
            if (!destinationSet.contains(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }
}
