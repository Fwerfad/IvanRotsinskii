package hw9.speller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TextDto {
    public static int IGNORE_DIGITS = 2;
    public static int IGNORE_URLS = 4;
    public static int FIND_REPEAT_WORDS = 8;
    public static int IGNORE_CAPITALIZATION = 512;
    private ArrayList<String> texts;
    private String text;
    private String lang;
    private int options;
    private String format;
    private ArrayList<String> expectedResults;
    private String expectedResult;
    private boolean unexpectedResult = false;
    private int endpoint = 1;
}
