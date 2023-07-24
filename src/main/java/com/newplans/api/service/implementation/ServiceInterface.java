package com.newplans.api.service.implementation;

public interface ServiceInterface<T1, T2> {
	T1 getById(Long id);
	
	T2 insert(T1 entity);
}
