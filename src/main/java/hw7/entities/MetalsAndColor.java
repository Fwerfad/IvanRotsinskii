package hw7.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MetalsAndColor extends DataClass {
    private ArrayList<Integer> summary;

    private ArrayList<String> elements;

    private String color;

    private String metals;

    private ArrayList<String> vegetables;
    
    public MetalsAndColor(ArrayList<Integer> summary, ArrayList<String> elements, String colors, String metals, ArrayList<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public int getEven() {
        return summary.get(1);
    }

    public int getOdd() {
        return summary.get(0);
    }

    public Map<String, String> returnMap() {
        Map<String, String> result = new HashMap<>();
        String summaryResult = String.valueOf(summary.get(0) + summary.get(1));
        String elementsResult = elements.toString().replace("[", "").replace("]", "");
        String vegetablesResult = vegetables.toString().replace("[", "").replace("]", "");
        result.put("Summary", summaryResult);
        result.put("Elements", elementsResult);
        result.put("Color", color);
        result.put("Metal", metals);
        result.put("Vegetables", vegetablesResult);
        return result;
    }
}
