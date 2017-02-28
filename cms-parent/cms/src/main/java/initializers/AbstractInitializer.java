package initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

@SuppressWarnings("rawtypes")
public abstract class AbstractInitializer<T extends CrudRepository> {
	@Autowired
	protected T repository;

	public abstract void initialize();
}
