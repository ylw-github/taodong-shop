package com.ylw.service.api.goods;

import com.ylw.api.product.dto.output.ProductDto;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * description: 商品搜索接口
 * create by: YangLinWei
 * create time: 2020/4/3 2:23 下午
 */
public interface ProductSearchService {
    @GetMapping("/search")
    public BaseResponse<List<ProductDto>> search(String name);

}
