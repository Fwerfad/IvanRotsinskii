package hw7.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
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

    public DataEntry(JSONArray summary, JSONArray elements, String color, String metals, JSONArray vegetables) {
        this.summary = new ArrayList<Integer>(convertList(summary.toList(), s -> (Integer) s));
        this.elements = new ArrayList<String>(convertList(elements.toList(), s -> (String) s));
        this.color = color;
        this.metals = metals;
        this.vegetables = new ArrayList<String>(convertList(vegetables.toList(), s -> (String) s));
    }
}
