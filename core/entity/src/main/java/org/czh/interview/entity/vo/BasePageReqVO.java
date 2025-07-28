package org.czh.interview.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.entity.IBasePageEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author : CZH
 * description : 分页 请求 接口实体 顶层父类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BasePageReqVO implements IBasePageEntity, IBaseReqVO {

    @Min(value = 1, message = "当前页码最小为1")
    @NotNull(message = "当前页码必填")
    @ApiModelProperty(value = "当前页码，必填", required = true, example = "1")
    protected Integer current;

    @Min(value = 1, message = "每页数量最小为1")
    @NotNull(message = "每页数量必填")
    @ApiModelProperty(value = "每页数量，必填", required = true, example = "10")
    protected Integer size;

}
