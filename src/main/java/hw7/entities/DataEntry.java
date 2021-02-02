package hw7.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.ToString;
import org.json.JSONArray;

@Getter
@ToString
public class DataEntry {
    private ArrayList<Integer> summary;

    private ArrayList<String>  elements;

    private String color;

    private String metals;

    private ArrayList<String>  vegetables;

    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }

    public DataEntry(ArrayList<Integer> summary, ArrayList<String> elements, String color, String metals, ArrayList<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public Map<String, String> returnMap() {
        Map<String, String> result = new HashMap<>();
        int summaryResult = 0;
        for (int i : summary) {
            summaryResult += i;
        }
        String elementsResult = "";
        for (int i = 0; i < elements.size(); i++) {
            elementsResult += elements.get(i);
            if (i != elements.size() - 1)
                elementsResult += ", ";
        }
        String vegetablesResult = "";
        for (int i = 0; i < vegetables.size(); i++) {
            vegetablesResult += vegetables.get(i);
            if (i != vegetables.size() - 1)
                vegetablesResult += ", ";
        }
        result.put("Summary", summaryResult + "");
        result.put("Elements", elementsResult);
        result.put("Color", color);
        result.put("Metal", metals);
        result.put("Vegetables", vegetablesResult);
        return result;
    }
}
