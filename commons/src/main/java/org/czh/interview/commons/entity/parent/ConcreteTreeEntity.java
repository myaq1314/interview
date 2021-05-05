package org.czh.interview.commons.entity.parent;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
public class ConcreteTreeEntity<T extends IBaseTreeEntity<T>> implements IBaseTreeEntity<T> {

    @Getter
    @Setter
    private List<T> children;

}
