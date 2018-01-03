package cn.nxnil.blueack.dmscenter.dao;

import cn.nxnil.blueack.dmscenter.model.FetchRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FetchRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FetchRecord record);

    int insertSelective(FetchRecord record);

    FetchRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FetchRecord record);

    int updateByPrimaryKey(FetchRecord record);

    /**
     * 批量插入
     *
     * @return
     */
    int insertList(List<FetchRecord> list);

    List<FetchRecord> findAll();

    FetchRecord selectByShopId(@Param("shopId") String shopId, @Param("createdDate") Integer createdDate);


    int findCount();

}