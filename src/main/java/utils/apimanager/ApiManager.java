package utils.apimanager;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;

public interface ApiManager<T> {
    void execute() throws JsonProcessingException;
}
