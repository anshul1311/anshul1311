package responsedto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Root {
    public ArrayList<Result> results;
    public Info info;

}
