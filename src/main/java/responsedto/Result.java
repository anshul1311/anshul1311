package responsedto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("results")
public class Result {
    public String gender;
    public Name name;
    public Location location;
    @NonNull
    public String email;
    public Login login;
    public Dob dob;
    public Registered registered;
    @NonNull
    public String phone;
    public String cell;
    public Id id;
    public Picture picture;
    public String nat;
}
