package cn.nxnil.blueack.client.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PromotionServiceRemote {

    @GET("/api/v2/allprice/yhsearch/price")
    Call<Object> queryPromotionPrice(@Query("shopid") String shopCode, @Query("random") int pageNum,
                                     @Query("listMember") int listMember, @Query("listAllInfo") int listAllInfo);
}
