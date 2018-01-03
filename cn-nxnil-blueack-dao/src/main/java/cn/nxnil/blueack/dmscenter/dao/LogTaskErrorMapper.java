package cn.nxnil.blueack.dmscenter.dao;

import cn.nxnil.blueack.dmscenter.model.LogTaskError;

public interface LogTaskErrorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogTaskError record);

    int insertSelective(LogTaskError record);

    LogTaskError selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogTaskError record);

    int updateByPrimaryKey(LogTaskError record);
}