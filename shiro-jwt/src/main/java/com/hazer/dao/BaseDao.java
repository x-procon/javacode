package com.hazer.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author hazer
 */
@NoRepositoryBean
public interface BaseDao<T, I extends Serializable>
		extends PagingAndSortingRepository<T, I>, JpaSpecificationExecutor<T> {

}
