package cn.ggx.test;

import cn.ggx.dao.ToolsItemDao;
import cn.ggx.dao.ToolsTypeDao;
import cn.ggx.entity.ToolsItem;
import cn.ggx.entity.ToolsType;
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

    }


}
