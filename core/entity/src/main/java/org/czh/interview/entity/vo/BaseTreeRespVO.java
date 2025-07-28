package org.czh.interview.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.entity.IBaseTreeEntity;

import java.util.List;

/**
 * @author : CZH
 * description : 树 响应 接口实体 顶层父类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BaseTreeRespVO<T extends BaseTreeRespVO<T>> implements IBaseTreeEntity<T>, IBaseRespVO {

    @ApiModelProperty(value = "子节点实体列表")
    protected List<T> children;

}
