package actanalyzer.api.service.implementation;

public abstract interface ServiceInterface<T> {
	T getById(T entity);
	
	T insert(T entity);
}
