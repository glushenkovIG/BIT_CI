package hello;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class MyDB {
    MyDB() {

    }

    int main() {
        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";


        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));

        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

        request.source(jsonString, XContentType.JSON);
        RequestOptions.Builder roptions = RequestOptions.DEFAULT.toBuilder();

        try {
            client.index(request, roptions.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //IndexResponse response = client.index("twitter", "_doc")
               // .setSource(json, XContentType.JSON)
               // .get();
        return 0;
    }


    void insert(String s){
        String a = "{\"user\": \"kimchy\", \"post_date\": \"2009-11-15T13:12:00\", " +
                "\"message\": \"Trying out Elasticsearch, so far so good?\" }";
    }

    String select(String s){

        return "1";
    }
}