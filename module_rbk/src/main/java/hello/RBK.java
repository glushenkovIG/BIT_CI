package hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class RBK {
    private List getDataFromRBK(int ndays){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://export.rbc.ru/free/selt.0/free.fcgi?period=DAILY&tickers=USD000000TOD&separator=TAB&data_format=BROWSER&lastdays=" + ndays;
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(fooResourceUrl, String.class);
        } catch (Exception e){
            return Arrays.asList("1 \t1\t 1\t 1\t 1\t 10");
        }

        List list = Arrays.asList(response.getBody().split("\n"));
        System.out.println(response.getBody());
        System.out.println(list.size());
        System.out.println(ndays);
        return list;
    }

    public String getMax() {
        int ndays = 10;
        List<String> list = getDataFromRBK(ndays);
        ndays = list.size();
        List<String> prices = new LinkedList<>();
        prices.add("0");

        for (int i = 0; i < ndays - 1; i++) {
            prices.add(Arrays.asList(list.get(i).split("\t")).get(5));
        }

        System.out.println(prices.toString());
        return Collections.max(prices);
    }
}

