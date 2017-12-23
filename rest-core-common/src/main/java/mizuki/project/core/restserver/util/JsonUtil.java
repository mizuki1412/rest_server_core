package mizuki.project.core.restserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper JSON = new ObjectMapper();
//    static {
//        JSON.setSerializationInclusion(Include.NON_NULL);
//        JSON.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
//    }

    public static ObjectMapper getJSON() {
        return JSON;
    }

    public static String toJson(Object obj) {
        try {
            return obj==null?null:JSON.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Map toMap(String str){
        try {
            return str==null?null:JSON.readValue(str,Map.class);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Object toObject(String str, Class clas){
        try {
            return str==null?null:JSON.readValue(str,clas);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}