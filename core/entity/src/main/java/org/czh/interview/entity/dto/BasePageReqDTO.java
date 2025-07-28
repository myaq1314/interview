package org.czh.interview.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.entity.IBasePageEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author : CZH
 * description : 分页 请求 传输 实体 顶层基类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BasePageReqDTO implements IBasePageEntity, IBaseReqDTO {

    @Min(value = 1, message = "当前页码最小为1")
    @NotNull(message = "当前页码必填")
    protected Integer current;

    @Min(value = 1, message = "每页数量最小为1")
    @NotNull(message = "每页数量必填")
    protected Integer size;

}