package utils.yamlreader;


import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class YamlReader {

    private static YamlReader yamlReader;
    private static ArrayList<Map<String, Object>> obj;
    private String filename;
    private String testcaseName;

    private YamlReader() {
    }

    public YamlReader(String filename, String testcaseName) throws IOException {
        this.filename = filename;
        this.testcaseName = testcaseName;
    }

    public static synchronized Map<String, Object> getData(String filename, String testcaseName) throws FileNotFoundException {
        if (null == yamlReader) {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(new File(filename));
            obj = yaml.load(inputStream);
        }
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).containsValue(testcaseName)) {
                return obj.get(i);
            }
        }
        return null;
    }
}