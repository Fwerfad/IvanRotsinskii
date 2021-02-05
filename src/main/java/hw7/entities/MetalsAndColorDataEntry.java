package hw7.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MetalsAndColorDataEntry extends DataClass {
    private String odd;

    private String even;

    private int[] elements;

    private String colors;

    private String metals;

    private int[] vegetables;

    public Map<String, Integer> elemKeys = new HashMap<String, Integer>() {{
        put("Water", 1);
        put("Earth", 2);
        put("Wind", 3);
        put("Fire", 4);
    }};

    public Map<Integer, String> elemValues = new HashMap<Integer, String>() {{
        put(1, "Water");
        put(2, "Earth");
        put(3, "Wind");
        put(4, "Fire");
    }};

    private Map<String, Integer> vegKeys = new HashMap<String, Integer>(){{
        put("Cucumber", 1);
        put("Tomato", 2);
        put("Vegetables", 3);
        put("Onion", 4);
    }
    };

    private Map<Integer, String> vegValues = new HashMap<Integer, String>(){{
        put(1, "Cucumber");
        put(2, "Tomato");
        put(3, "Vegetables");
        put(4, "Onion");
    }
    };

    public MetalsAndColorDataEntry(ArrayList<Integer> summary, ArrayList<String> elements, String colors, String metals, ArrayList<String> vegetables) {

        this.odd = summary.get(0) + "";
        this.even = summary.get(1) + "";
        this.elements = new int[elements.size()];
        this.colors = colors;
        this.metals = metals;
        this.vegetables = new int[vegetables.size()];
        for (int i = 0; i < elements.size(); i++) {
            this.elements[i] = elemKeys.get(elements.get(i));
        }
        for (int i = 0; i < vegetables.size(); i++) {
            this.vegetables[i] = vegKeys.get(vegetables.get(i));
        }
    }

    public Map<String, String> returnMap() {
        Map<String, String> result = new HashMap<>();
        int summaryResult = Integer.parseInt(odd) + Integer.parseInt(even);
        String elementsResult = "";
        for (int i = 0; i < elements.length; i++) {
            elementsResult += elemValues.get(elements[i]);
            if (i != elements.length - 1)
                elementsResult += ", ";
        }
        String vegetablesResult = "";
        for (int i = 0; i < vegetables.length; i++) {
            vegetablesResult += vegValues.get(vegetables[i]);
            if (i != vegetables.length - 1)
                vegetablesResult += ", ";
        }
        result.put("Summary", summaryResult + "");
        result.put("Elements", elementsResult);
        result.put("Color", colors);
        result.put("Metal", metals);
        result.put("Vegetables", vegetablesResult);
        return result;
    }
}
