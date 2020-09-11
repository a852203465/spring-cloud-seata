package cn.darkjrong.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Rong.Jia
 * @date 2020/08/28 15:57
 */
@Data
@TableName("tb_goods")
public class Goods {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String name;

    private Long stockNum;

    private Long money;

    private Long createTime;

    private Long updateTime;

    private Byte isDeleted;
















}
