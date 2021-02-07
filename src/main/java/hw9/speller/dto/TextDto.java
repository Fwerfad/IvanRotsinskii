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
