package cn.ggx.dao;

import cn.ggx.entity.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BannerDao {

    int addBanner(Banner banner);

    List<Banner> findBannerByCondition(Map<String,String> map);

    List<Banner> findBannerByIds(List<Integer> list);

    int addBanners(List<Banner> lists);

    int updateBanners(List<Banner> banners);

    List<Banner> findBannerAll();

}
