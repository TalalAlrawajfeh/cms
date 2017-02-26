package beans;

@FunctionalInterface
public interface BeanBuilder<T> {
    T build();
}
