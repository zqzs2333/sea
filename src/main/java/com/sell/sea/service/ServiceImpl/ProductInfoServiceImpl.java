package com.sell.sea.service.ServiceImpl;

import com.sell.sea.DTO.ProductDTO;
import com.sell.sea.bean.ProductInfo;
import com.sell.sea.bean.UserComment;
import com.sell.sea.bean.UserJoin;
import com.sell.sea.dao.ProductInfoDao;
import com.sell.sea.dao.UserCommentDao;
import com.sell.sea.dao.UserjoinDao;
import com.sell.sea.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    private UserjoinDao userjoinDao;
    @Autowired
    private UserCommentDao userCommentDao;
    @Override
    public List<ProductDTO> findByHotList() {
        List<ProductInfo> isHotList = productInfoDao.findByIsHot(0);
//        List<String> hotIdList = isHotList.stream().map(e -> e.getProductId()).collect(Collectors.toList());
        List<ProductDTO> productDTOList =new ArrayList<>();
        for (ProductInfo productInfo : isHotList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productInfo,productDTO);
//            List<UserComment> byProductId = userCommentDao.findByProductId(productInfo.getProductId()) ;
            productDTO.setUserComment(userCommentDao.findByProductId(productInfo.getProductId()));
            productDTO.setUserJoin(userjoinDao.findByProductId(productInfo.getProductId()));
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> list() {
        List<ProductInfo> allList = productInfoDao.findAll();
//        List<String> hotIdList = isHotList.stream().map(e -> e.getProductId()).collect(Collectors.toList());
        List<ProductDTO> productDTOList =new ArrayList<>();
        for (ProductInfo productInfo : allList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productInfo,productDTO);
//            List<UserComment> byProductId = userCommentDao.findByProductId(productInfo.getProductId()) ;
            productDTO.setUserComment(userCommentDao.findByProductId(productInfo.getProductId()));
            productDTO.setUserJoin(userjoinDao.findByProductId(productInfo.getProductId()));
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findByType(Integer categoryId) {
        List<ProductInfo> typeList = productInfoDao.findByProductType(categoryId);

//        List<String> hotIdList = isHotList.stream().map(e -> e.getProductId()).collect(Collectors.toList());
        List<ProductDTO> productDTOList =new ArrayList<>();
        for (ProductInfo productInfo : typeList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productInfo,productDTO);
//            List<UserComment> byProductId = userCommentDao.findByProductId(productInfo.getProductId()) ;
            productDTO.setUserComment(userCommentDao.findByProductId(productInfo.getProductId()));
            productDTO.setUserJoin(userjoinDao.findByProductId(productInfo.getProductId()));
            productDTOList.add(productDTO);
        }
        return productDTOList;

    }

    @Override
    public List<ProductDTO> findByUserName(String userName) {
        List<ProductInfo> byUserName = productInfoDao.findByUserName(userName);

        List<ProductDTO> productDTOList =new ArrayList<>();
        for (ProductInfo productInfo : byUserName) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productInfo,productDTO);
//            List<UserComment> byProductId = userCommentDao.findByProductId(productInfo.getProductId()) ;
            productDTO.setUserComment(userCommentDao.findByProductId(productInfo.getProductId()));
            productDTO.setUserJoin(userjoinDao.findByProductId(productInfo.getProductId()));
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public ProductInfo findone(String productId) {

        return productInfoDao.findById(productId).orElse(null);
    }

    @Override
    public ProductInfo delete(String productId) {
        return productInfoDao.deleteByProductId(productId);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public List<ProductInfo> findByProductNameLike(String productName) {
        return productInfoDao.findByProductNameLike("%"+productName+"%");
    }
}
