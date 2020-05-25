package com.ylw.service.spike.mapper;

import com.ylw.service.spike.mapper.entity.SeckillEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SeckillMapper {

    @Select("SELECT seckill_id AS seckillId,name as name,inventory as inventory,start_time as startTime,end_time as endTime,create_time as createTime,version as version from seckill where seckill_id=#{seckillId}")
    SeckillEntity findBySeckillId(Long seckillId);

    /**
     * 悲观锁防止超卖
     *
     * @param seckillId
     * @return
     */
    @Update("update seckill set inventory=inventory-1 where  seckill_id=#{seckillId} and inventory>0;")
    int pessimisticDeduction(@Param("seckillId") Long seckillId);

    /**
     * 乐观锁防止超卖
     *
     * @param seckillId
     * @param version
     * @return
     */
    @Update("update seckill set inventory=inventory-1, version=version+1 where  seckill_id=#{seckillId} and inventory>0  and version=#{version} ;")
    int optimisticDeduction(@Param("seckillId") Long seckillId, @Param("version") Long version);

    // update seckill set inventory=inventory-1 where
    // seckill_id=#{seckillId} and 1>0;
    // update seckill set inventory=inventory-1 where
    // seckill_id=#{seckillId} and 1>0;
    // 在mysql中每次在更新数据库有行锁机制

    // UPDATE seckill SET inventory=inventory-1 ,version=version+1 FROM
    // seckill WHERE seckill_id='10001' and version='1';

}