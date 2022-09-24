package responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {
    public String seed;
    public int results;
    public int page;
    public String version;
}
