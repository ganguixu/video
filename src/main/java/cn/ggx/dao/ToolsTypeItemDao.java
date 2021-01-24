package cn.ggx.dao;

import cn.ggx.entity.ToolsType;

import java.util.List;

public interface ToolsTypeItemDao {

    List<ToolsType> findToolsTypeAll();

    List<ToolsType> findToolsTypeByIds(List<Integer> list);
}
