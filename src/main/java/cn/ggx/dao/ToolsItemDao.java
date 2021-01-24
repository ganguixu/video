package cn.ggx.dao;

import cn.ggx.entity.ToolsItem;

import java.util.List;
import java.util.Map;

public interface ToolsItemDao {

    int addToolsItem(ToolsItem toolsItem);

    int updateToolsItem(ToolsItem toolsItem);

    List<ToolsItem> findToolsItemByCondition(Map<String,Integer> map);
}
