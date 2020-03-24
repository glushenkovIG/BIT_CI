package hello;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MyElasticSearchAdventuresTest {
    MyElasticSearchAdventures myElasticSearchAdventures = new MyElasticSearchAdventures();

    @Test
    public void initial_request() {
        myElasticSearchAdventures.initial_request();
    }

    @Test
    public void test1(){
        String data = "Test data 11111";

        myElasticSearchAdventures.insert("key1", data);

    }

    @Test
    public void test2(){
            String data = "Test data 222222";

            myElasticSearchAdventures.insert("key2", data);
    }

    @Test
    public void get(){
        myElasticSearchAdventures.get("key1");
    }

    @Test
    public void getFromCache(){
        String key = "key5";
        String value = "Test data: " + key;

        myElasticSearchAdventures.insert(key, value);
        System.out.println(myElasticSearchAdventures.get(key));
        System.out.println(myElasticSearchAdventures.get(key));
    }
}