package cn.ggx.test;

import cn.ggx.dao.BannerDao;
import cn.ggx.entity.Banner;
import cn.ggx.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class BannerDaoTest {

    @Autowired
    BannerDao bannerDao ;

    @Test
    public void test1(){
        Banner banner = new Banner();
        banner.setFlag(0);
        banner.setCreateTime(new Date());
        banner.setImgUrl("www.baidu.com");
        banner.setTargetUrl("paas.fescoadecco.com");
        banner.setType(1);
        int code = bannerDao.addBanner(banner);
        System.out.println(code);
    }

    @Test
    public void test2(){
        Map<String,String> map = new HashMap<String, String>();
        List<Integer> list = new ArrayList<Integer>();
        map.put("target_url","paas.fescoadecco.com");
        List<Banner> bannerByCondition = bannerDao.findBannerByCondition(map);
//        System.out.println(bannerByCondition);
        for (Banner banner : bannerByCondition){
            list.add(banner.getId());
        }
        List<Banner> bannerByIds = bannerDao.findBannerByIds(list);
        System.out.println(bannerByIds);
        List<Banner> list1 = new ArrayList<Banner>();
        for (Banner banner : bannerByIds){
            Banner banner1 = new Banner(banner.getImgUrl(),banner.getTargetUrl(),banner.getType(),banner.getFlag(),new Date());
            list1.add(banner1);
        }
        int code = bannerDao.addBanners(list1);
        System.out.println(code);
    }

    @Test
    public void Test3(){
        List<Banner> bannerAll = bannerDao.findBannerAll();
        List<Banner> bannerList = new ArrayList<Banner>();
        for (Banner banner : bannerAll){
            if(banner.getFlag()==1){
                Banner banner1 = new Banner();
                banner1.setId(banner.getId());
                banner1.setType(0);
                bannerList.add(banner1);
            }
        }
        System.out.println(bannerList);
        int code = bannerDao.updateBanners(bannerList);
        System.out.println(code);
    }


}
