package cn.ggx.test;

import cn.ggx.dao.ToolsItemDao;
import cn.ggx.dao.ToolsTypeDao;
import cn.ggx.entity.ToolsItem;
import cn.ggx.entity.ToolsType;
import cn.ggx.entity.ToolsTypeItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class ToolsItemTest {

    @Autowired
    ToolsItemDao toolsItemDao ;

    @Autowired
    ToolsTypeDao toolsTypeDao ;

    @Test
    public void test1(){
        List<ToolsType> toolsTypes = toolsTypeDao.findToolsTypeAll();
        ToolsItem toolsItem = new ToolsItem();
        for (ToolsType toolsType:toolsTypes){
            if("会员专区".equals(toolsType.getName())){
                toolsItem.setCreateTime(new Date());
                toolsItem.setFlag(0);
                toolsItem.setImgUrl("ssss/sss/img.jpg");
                toolsItem.setName("mybatis教程");
                toolsItem.setToolsTypeId(toolsType.getId());
                toolsItem.setToolsUrl("www.baidu.com");
            }
        }
        int code = toolsItemDao.addToolsItem(toolsItem);
        System.out.println(code);
    }

    @Test
    public void test2(){
        ToolsItem toolsItem = new ToolsItem();
        toolsItem.setId(1);
        toolsItem.setName("javaSE基础教程");
        toolsItem.setImgUrl("https://locahost:8080/index.jsp&uname=111&upass=123");
        int code = toolsItemDao.updateToolsItem(toolsItem);
        System.out.println(code);
    }

    @Test
    public void test3(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        List<ToolsType> toolsTypeByIds = toolsTypeDao.findToolsTypeByIds(list);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("toolsTypeId",toolsTypeByIds.get(0).getId());
        List<ToolsItem> toolsItemByCondition = toolsItemDao.findToolsItemByCondition(map);
        List<ToolsTypeItem> toolsTypeItemList = new ArrayList<ToolsTypeItem>();
        for (ToolsItem toolsItem : toolsItemByCondition){
            ToolsTypeItem toolsTypeItem = new ToolsTypeItem();
            toolsTypeItem.setToolsTypeId(toolsTypeByIds.get(0).getId());
            toolsTypeItem.setToolsTypeName(toolsTypeByIds.get(0).getName());
            toolsTypeItem.setToolsTypeFlag(toolsTypeByIds.get(0).getFlag());
            toolsTypeItem.setToolsTypeCreateTime(toolsTypeByIds.get(0).getCreateTime());
            toolsTypeItem.setToolsItemId(toolsItem.getId());
            toolsTypeItem.setToolsItemCreateTime(toolsItem.getCreateTime());
            toolsTypeItem.setToolsItemFlag(toolsItem.getFlag());
            toolsTypeItem.setToolsItemImgUrl(toolsItem.getImgUrl());
            toolsTypeItem.setToolsItemName(toolsItem.getName());
            toolsTypeItem.setToolsItemToolsTypeId(toolsItem.getToolsTypeId());
            toolsTypeItem.setToolsItemToolsUrl(toolsItem.getToolsUrl());
            toolsTypeItemList.add(toolsTypeItem);
        }
        for (ToolsTypeItem toolsTypeItem : toolsTypeItemList){
            System.out.println(toolsTypeItem);
        }

        Map<ToolsType,List<ToolsTypeItem>> map1 = new HashMap<ToolsType, List<ToolsTypeItem>>();
        map1.put(toolsTypeByIds.get(0),toolsTypeItemList);
        System.out.println(map1);

        List<ToolsTypeItem> toolsTypeItemList1 = map1.get(toolsTypeByIds.get(0));
        for (ToolsTypeItem toolsTypeItem : toolsTypeItemList1){
            if ("Spring教程".equals(toolsTypeItem.getToolsItemName())){
                System.out.println(toolsTypeItem);
            }
        }


    }


}
