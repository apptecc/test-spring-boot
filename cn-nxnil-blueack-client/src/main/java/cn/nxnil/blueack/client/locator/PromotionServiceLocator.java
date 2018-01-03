package cn.nxnil.blueack.client.locator;

import cn.nxnil.blueack.client.remote.PromotionServiceRemote;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class PromotionServiceLocator {
    private final okhttp3.OkHttpClient client = new OkHttpClient.Builder()
            .build();
    // DMS URL
    public String promotionServiceApiUri = "http://openapis.yonghui.cn";

    public PromotionServiceLocator() {

    }

    public PromotionServiceRemote createPromotionServiceRemote() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(promotionServiceApiUri)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(PromotionServiceRemote.class);
    }

}
