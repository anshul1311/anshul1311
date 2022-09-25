package responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    public Street street;
    public String city;
    public String state;
    public String country;
    public String postcode;
    public Coordinates coordinates;
    public Timezone timezone;
}
