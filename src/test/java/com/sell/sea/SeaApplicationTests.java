package com.sell.sea;

import com.sell.sea.DTO.ProductDTO;
import com.sell.sea.bean.UserInfo;
import com.sell.sea.dao.UserDao;
import com.sell.sea.service.ProductInfoService;
import com.sell.sea.service.ServiceImpl.ProductInfoServiceImpl;
import com.sell.sea.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SeaApplicationTests {

    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ProductInfoServiceImpl productInfoService;
    @Test
    void contextLoads() {
        List<ProductDTO> byHotList = productInfoService.findByHotList();
        System.out.println(byHotList);

    }

}
