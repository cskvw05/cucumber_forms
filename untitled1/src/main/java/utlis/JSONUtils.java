package utlis;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSONUtils {

    public static Map<String, Object> loadJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), Map.class);
    }

    public static Map<String, Object> getFormMapping() throws IOException {
        return loadJSON("resources/config/form_mapping.json");
    }

    public static Map<String, Object> getTestData() throws IOException {
        return loadJSON("resources/config/test_data.json");
    }
}
