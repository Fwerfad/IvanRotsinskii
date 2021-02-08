package hw9.speller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ResponseDto {
    ArrayList<String> s;
    String word;
    int code;
    int pos;
    int row;
    int col;
    int len;

    public ResponseDto() {
        s = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "texts=" + s +
                '}';
    }
}
