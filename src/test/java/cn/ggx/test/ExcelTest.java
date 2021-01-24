package cn.ggx.test;

import cn.ggx.dao.ToolsTypeDao;
import cn.ggx.dao.ToolsTypeItemDao;
import cn.ggx.entity.ToolsItem;
import cn.ggx.entity.ToolsType;
import cn.ggx.util.ExcelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class ExcelTest {

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Autowired
    ToolsTypeItemDao toolsTypeItemDao;

    @Test
    public void test1() throws IOException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<ToolsType> toolsTypes = toolsTypeItemDao.findToolsTypeByIds(list);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (ToolsType toolsType : toolsTypes) {
            List<ToolsItem> toolsItems = toolsType.getToolsItems();
            if (toolsItems.size()>0) {
                for (ToolsItem toolsItem : toolsItems) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("id", String.valueOf(toolsType.getId()));
                    map.put("name", toolsType.getName());
                    map.put("flag", String.valueOf(toolsType.getFlag()));
                    map.put("createTime", simpleDateFormat.format(toolsType.getCreateTime()));
                    map.put("itemId", String.valueOf(toolsItem.getId()));
                    map.put("itemName", toolsItem.getName());
                    map.put("toolsUrl", toolsItem.getToolsUrl());
                    map.put("imgUrl", toolsItem.getImgUrl());
                    map.put("toolsTypeId", String.valueOf(toolsItem.getToolsTypeId()));
                    map.put("itemFlag", String.valueOf(toolsItem.getFlag()));
                    map.put("itemCreateTime", simpleDateFormat.format(toolsItem.getCreateTime()));
                    dataList.add(map);
                }
            }else {
                Map<String,String> map = new HashMap<String, String>();
                map.put("id",String.valueOf(toolsType.getId()));
                map.put("name",toolsType.getName());
                map.put("flag",String.valueOf(toolsType.getFlag()));
                map.put("createTime",simpleDateFormat.format(toolsType.getCreateTime()));
                dataList.add(map);
            }
        }
        String[] titles = new String[]{"类型ID", "类型名称", "类型状态", "类型创建时间", "明细ID", "明细名称", "明细URL", "图片URL", "明细类型", "明细状态", "明细创建时间"};
        String[] fields = new String[]{"id", "name", "flag", "createTime", "itemId", "itemName", "toolsUrl", "imgUrl", "toolsTypeId", "itemFlag", "itemCreateTime"};
        ExcelUtils.createExcel(titles, fields, dataList, "xlsx", "toolsTypeItem");
    }
}
