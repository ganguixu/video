package cn.ggx.dao;

import cn.ggx.entity.ToolsType;

import java.util.List;
import java.util.Map;

public interface ToolsTypeDao {

    int addToolsTypes(List<ToolsType> list);

    List<ToolsType> findToolsTypeAll();

    List<ToolsType> findToolsTypeByIds(List<Integer> list);
}
