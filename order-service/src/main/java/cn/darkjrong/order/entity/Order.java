package cn.darkjrong.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Rong.Jia
 * @date 2020/08/28 15:46
 */
@Data
@TableName("tb_order")
public class Order  {

    @TableId(  type = IdType.ID_WORKER)
    private Long id;

    private String orderNo;

    private Long userId;

    private Long goodsId;

    private Long createTime;

    private Long updateTime;

    private Byte isDeleted;







}
