package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.BillEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = BillEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface BillDAO {
	@Query(name = "save")
	BillEntity save(BillEntity billEntity);
}
