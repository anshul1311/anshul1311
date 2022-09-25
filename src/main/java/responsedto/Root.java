package responsedto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Root {
    public ArrayList<Result> results;
    public Info info;

}
