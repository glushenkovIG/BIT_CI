package hello;

import org.apache.catalina.connector.Request;

import java.util.List;

class MyService implements Service{
    private Service service;

    void MyService(Service service){
        this.service = service;
    }

    @Override
    public void save(List<String> data) {

    }

    @Override
    public String getById(String id) {
        return null;
    }

    @Override
    public List<String> getAll() {
        return service.getAll();
    }

    @Override
    public List<String> getByRequest(Request request) {
        return null;
    }
}