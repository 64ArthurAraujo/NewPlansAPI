package br.org.actanalyzer.api.service.implementation;

public abstract interface ServiceInterface<T1, T2> {
	T1 getById(T1 entity);
	
	T2 insert(T1 entity);
}
