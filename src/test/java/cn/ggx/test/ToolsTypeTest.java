package cn.ggx.test;

import cn.ggx.dao.ToolsTypeDao;
import cn.ggx.entity.ToolsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class ToolsTypeTest {

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Test
    public void test1(){
        List<ToolsType> list = new ArrayList<ToolsType>();
        ToolsType toolsType = new ToolsType();
        toolsType.setName("会员专区");
        toolsType.setFlag(1);
        toolsType.setCreateTime(new Date());
        list.add(toolsType);
        ToolsType toolsType1 = new ToolsType();
        toolsType1.setName("游客专区");
        toolsType1.setFlag(0);
        toolsType1.setCreateTime(new Date());
        list.add(toolsType1);
        int i = toolsTypeDao.addToolsTypes(list);
        System.out.println(i);
    }
}
