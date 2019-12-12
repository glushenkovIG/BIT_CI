package hello;

import org.junit.Test;

public class MyElasticSearchAdventuresTest {
    MyElasticSearchAdventures myElasticSearchAdventures = new MyElasticSearchAdventures();

    @Test
    public void initial_request() {
        myElasticSearchAdventures.initial_request();
    }

    @Test
    public void test1(){
        String s = "http://localhost:9200/mkyong/posts/1001";
        String data = "{\n" +
                "  \"title\": \"Spring + Spring Data + ElasticSearch\",\n" +
                "  \"category\":\"Spring Boot\",\n" +
                "  \"published_date\":\"23-MAR-2017\",\n" +
                "  \"author\":\"Rambabu Posa\"\n" +
                "}";

        myElasticSearchAdventures.insert(s, data);
    }

    @Test
    public void test2(){
            String s = "http://localhost:9200/twitter/_doc/1?pretty";
            String data = "{ \"user\": \"kimchy\", \"post_date\": \"2009-11-15T13:12:00\", \"message\": \"Trying out Elasticsearch, so far so good?\"}";

            myElasticSearchAdventures.insert(s, data);
    }
}