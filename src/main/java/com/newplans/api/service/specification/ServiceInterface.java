package com.newplans.api.service.specification;

import com.newplans.api.exception.NoSuchEntryException;

public interface ServiceInterface<T1, T2> {
	T1 getById(Long id) throws NoSuchEntryException;
	
	T2 insert(T1 entity);
}
