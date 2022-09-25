package utils.yamlreader;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class YamlWriter {
    static String basePath = System.getProperty("user.dir") + "/src/test/resources/data/";
    private static YamlWriter yamlWriter;
    private static ArrayList<Map<String, Object>> obj;
    private String filename;
    private String testcaseName;

    public YamlWriter(String filename, String testcaseName) throws IOException {
        this.filename = filename;
        this.testcaseName = testcaseName;
    }

    public static synchronized void getData(String filename, String testcaseName, Map<String, String> valueToUpdate) throws IOException {

        if (null == yamlWriter) {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(new File(filename));
            obj = yaml.load(inputStream);
        }
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).containsValue(testcaseName)) {
                obj.get(i);
                //ObjectMapper objectMapper = new YAMLMapper();
                Map<String, Object> testcase = obj.get(i);
                Map<String, Object> testdata = (Map<String, Object>) testcase.get("testdata");
                testdata.putAll(valueToUpdate);
                //objectMapper.writeValue(new File(filename), obj);
            }
        }
    }
}
