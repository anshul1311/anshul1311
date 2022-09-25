package utils.apimanager;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import responsedto.Root;
import utils.CommonApi;
import utils.logger.Log;

public class CreateUserApiManager extends CommonApi implements ApiManager {
@Setter
@Getter
Root root;
Response response;
String url;
public CreateUserApiManager(String url){
    this.url=url;
}
    @Override
    public void execute() throws JsonProcessingException {
        Log.info("Inside Random Api Execute Method");
         response = getApiResponse(url, null, null, null, 200);
        Log.info("Random Api Executed with response"+ response);


    }

    public void setApiData() throws JsonProcessingException {
        Log.info("Inside SetApiData Method");
        ObjectMapper mapper = new ObjectMapper();
        root = mapper.readValue(response.asString(), Root.class);
        System.out.println(response.asString());
    }
}
