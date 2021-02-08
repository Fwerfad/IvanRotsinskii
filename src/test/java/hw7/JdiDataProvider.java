package hw7;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import hw7.entities.MetalsAndColor;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class JdiDataProvider {
    @DataProvider(name = "data-provider")
    @SneakyThrows
    public Iterator<Object> dpMethod(){
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json")), StandardCharsets.UTF_8);; //assign your JSON String here
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        Set<String> keyset = jsonParser.parse(jsonString).getAsJsonObject().keySet();
        Collection<Object> dp = new ArrayList<Object>();
        for (String key : keyset) {
            String s = jsonParser.parse(jsonString).getAsJsonObject().get(key).toString();
            dp.add(gson.fromJson(s, MetalsAndColor.class));
        }
        return dp.iterator();
    }
}
