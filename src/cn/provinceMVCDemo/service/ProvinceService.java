package cn.provinceMVCDemo.service;

import cn.provinceMVCDemo.domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    String findAllRedis();
}
