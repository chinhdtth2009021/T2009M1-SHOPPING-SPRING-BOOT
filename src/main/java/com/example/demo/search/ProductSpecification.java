package com.example.demo.search;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//public class ProductSpecification {
//}
public class ProductSpecification implements Specification<Product> {

    private SearchCriteria searchCriteria;


    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.getOperation().equalsIgnoreCase(">=")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), String.valueOf(searchCriteria));
        }else if (searchCriteria.getOperation().equalsIgnoreCase("<=")){
            return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()),String.valueOf(searchCriteria));
        }else if (searchCriteria.getOperation().equalsIgnoreCase(">")){
            return criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()),String.valueOf(searchCriteria));
        }else if (searchCriteria.getOperation().equalsIgnoreCase("<")){
            return criteriaBuilder.lessThan(root.get(searchCriteria.getKey()),String.valueOf(searchCriteria));
        }else if (searchCriteria.getOperation().equalsIgnoreCase("=")){
            if (root.get(searchCriteria.getKey()).getJavaType()== String.class){
                return criteriaBuilder.like(
                        root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");

            }else {
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }
}
