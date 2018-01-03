package cn.nxnil.blueack.client.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HttpClientUtils {

    private CloseableHttpClient client;

    @Value("${httpclient.pool.max.total:20}")
    private int httpclientPoolMaxTotal;

    PoolingHttpClientConnectionManager buildConnectionPool(int httpclientPoolMaxTotal) {
        PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
        poolingConnManager.setMaxTotal(httpclientPoolMaxTotal);
        return poolingConnManager;
    }

    public CloseableHttpClient buildHttpClient() {
        if (client != null)
            return client;
        client = HttpClients.custom().setConnectionManager(buildConnectionPool(httpclientPoolMaxTotal)).build();
        return client;
    }


//    public static void main(String[] args) {
//        String s = "4.85722573273506e+11";
//        String s1 = "-4.85722573273506e-17";
//        Double d = Double.valueOf(4.857225732735061111111e+11);
//        Double d1 = Double.valueOf(-4.85722573273506e-17);
//
////        NumberFormat formatter = new DecimalFormat("###.#####");
//        BigDecimal b = BigDecimal.valueOf(d);
//        BigDecimal b1 = BigDecimal.valueOf(d1);
//        System.out.println(d);
//        System.out.println(d1);
//
//        b1 = b1.setScale(6, RoundingMode.HALF_UP);
//        b = b.setScale(6, RoundingMode.HALF_UP);
//        System.out.println(b.toPlainString());
//        System.out.println(b1.toPlainString());
////        System.out.println(formatter.format(d));
////        System.out.println(formatter.format(d1));
//    }


}
