package hello;

import org.apache.catalina.connector.Request;

import java.util.List;

interface Service {
    void save(List<String> data);

    String getById(String id);


    List<String> getAll();

    List<String> getByRequest(Request request);
}