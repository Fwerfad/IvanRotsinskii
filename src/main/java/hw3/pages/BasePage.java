package hw3.pages;

import java.util.ArrayList;

public class BasePage {
    protected <T> ArrayList<Boolean> checkOneInAnother(ArrayList<T> names, ArrayList<T> actualNames) {
        ArrayList<Boolean> arr = new ArrayList<>();
        for (T name : names)
            if (actualNames.contains(name))
                arr.add(true);
            else
                arr.add(false);
        return arr;
    }
}
