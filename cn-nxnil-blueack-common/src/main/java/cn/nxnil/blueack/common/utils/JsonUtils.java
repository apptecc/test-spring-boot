package cn.nxnil.blueack.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

    private static ObjectMapper om = new ObjectMapper();

    static {
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        om.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    public static String toJson(Object o) {
        try {
            return om.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static <T> T toObject(String json, Class<T> z) {
        try {
            return om.readValue(json, z);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> T readFromInputStream(InputStream inputStream, Class<T> z) {
        try {
            return om.readValue(inputStream, z);
        } catch (Exception e) {
            return null;
        }
    }

}
