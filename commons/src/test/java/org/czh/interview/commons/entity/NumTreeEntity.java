package org.czh.interview.commons.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.czh.interview.commons.entity.parent.IBaseTreeEntity;

import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
@Data
@ToString
@EqualsAndHashCode
public class NumTreeEntity implements IBaseTreeEntity<NumTreeEntity> {

    private List<NumTreeEntity> children;

    private String id;
    private String parentId;

    public NumTreeEntity() {
    }

    public NumTreeEntity(String id, String parentId) {
        this.id = id;
        this.parentId = parentId;
    }


}
