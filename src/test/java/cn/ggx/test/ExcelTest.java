package cn.ggx.test;

import cn.ggx.dao.ToolsItemDao;
import cn.ggx.dao.ToolsTypeDao;
import cn.ggx.entity.ToolsItem;
import cn.ggx.entity.ToolsType;
import cn.ggx.entity.ToolsTypeItem;
import cn.ggx.util.ExcelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.text.resources.FormatData;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class ExcelTest {

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Autowired
    ToolsItemDao toolsItemDao;

    @Test
    public void test1() throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<ToolsType> toolsTypes = toolsTypeDao.findToolsTypeByIds(list);
        List<ToolsTypeItem> toolsTypeItemList = new ArrayList<ToolsTypeItem>();
        for (ToolsType toolsType : toolsTypes){
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("toolsTypeId",toolsType.getId());
            List<ToolsItem> toolsItemByCondition = toolsItemDao.findToolsItemByCondition(map);
            for (ToolsItem toolsItem : toolsItemByCondition) {
                ToolsTypeItem toolsTypeItem = new ToolsTypeItem();
//            toolsTypeItem.setToolsTypeId(toolsType.getId());
//            toolsTypeItem.setToolsTypeName(toolsType.getName());
//            toolsTypeItem.setToolsTypeFlag(toolsType.getFlag());
//            toolsTypeItem.setToolsTypeCreateTime(toolsType.getCreateTime());
                toolsTypeItem.setToolsItemId(toolsItem.getId());
                toolsTypeItem.setToolsItemCreateTime(toolsItem.getCreateTime());
                toolsTypeItem.setToolsItemFlag(toolsItem.getFlag());
                toolsTypeItem.setToolsItemImgUrl(toolsItem.getImgUrl());
                toolsTypeItem.setToolsItemName(toolsItem.getName());
                toolsTypeItem.setToolsItemToolsTypeId(toolsItem.getToolsTypeId());
                toolsTypeItem.setToolsItemToolsUrl(toolsItem.getToolsUrl());
                toolsTypeItemList.add(toolsTypeItem);
            }

            for (ToolsTypeItem toolsTypeItem : toolsTypeItemList) {
                Integer toolsTypeId = toolsTypeItem.getToolsTypeId();

            }

        }


        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        Set<String> titleSets = new HashSet<String>();
        for (
                ToolsTypeItem toolsTypeItem : toolsTypeItemList) {
            Class clazz = toolsTypeItem.getClass();
            Map<String, String> dataMap = new HashMap<String, String>();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                StringBuilder fieldName = new StringBuilder(field.getName());
                if (!"serialVersionUID".equals(fieldName.toString())) {
                    fieldName.replace(0, 1, fieldName.substring(0, 1).toUpperCase());
                    String methodName = "get" + fieldName;
                    titleSets.add(fieldName.toString());
                    Method declaredMethod = clazz.getMethod(methodName);
                    Object value = declaredMethod.invoke(toolsTypeItem);
                    if (value != null && field.getType() == Date.class) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        value = simpleDateFormat.format(value);
                    }
                    dataMap.put(fieldName.toString(), String.valueOf(value));
                }
            }
            dataList.add(dataMap);
        }

        String[] titles = titleSets.toArray(new String[titleSets.size()]);
        System.out.println(titles.length);
        ExcelUtils.createExcel(titles, titles, dataList, "xlsx", "ToolsTypeItem");


    }
}
