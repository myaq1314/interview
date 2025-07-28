package org.czh.interview.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.entity.IBaseTreeEntity;

import java.util.List;

/**
 * @author : CZH
 * description : 树 响应 传输 实体 顶层父类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BaseTreeRespDTO<T extends BaseTreeRespDTO<T>> implements IBaseTreeEntity<T>, IBaseRespDTO {

    @ApiModelProperty(value = "子节点实体列表")
    protected List<T> children;

}
