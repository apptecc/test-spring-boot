package cn.nxnil.blueack.dmscenter.dao;

import cn.nxnil.blueack.dmscenter.model.ShopProductPromoInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopProductPromoInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopProductPromoInfo record);

    int insertSelective(ShopProductPromoInfo record);

    ShopProductPromoInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopProductPromoInfo record);

    int updateByPrimaryKey(ShopProductPromoInfo record);

    int insertList(@Param("pojos") List<ShopProductPromoInfo> pojo);

    int batchInsertOrUpdate(@Param("list") List<ShopProductPromoInfo> list);

    int deleteByShopCode(@Param("shopCode") String shopCode);


}