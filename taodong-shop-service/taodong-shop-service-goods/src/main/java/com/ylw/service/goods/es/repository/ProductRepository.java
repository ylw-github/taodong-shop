package com.ylw.service.goods.es.repository;

import com.ylw.service.goods.es.entity.ProductEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductEntity, Long> {

}
 