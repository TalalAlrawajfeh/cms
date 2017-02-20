package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class CopyUtil {
	private static final String CREATE_AND_COPY_FIELDS_ERROR = "Create And Copy Fields Error";
	private static final String SET_PREFIX = "set";
	private static final String GET_PREFIX = "get";
	private static final String IS_PREFIX = "is";

	private static Logger logger = Logger.getLogger(CopyUtil.class);

	private CopyUtil() {
		/* static class */
	}

	public static <D, S> D createAndCopyFields(Class<D> destionationClass, S source) {
		try {
			D destination = destionationClass.newInstance();
			copyFields(destination, source);

			return destination;
		} catch (Exception e) {
			logger.error(CREATE_AND_COPY_FIELDS_ERROR, e);

			throw new UtilException(e);
		}
	}

	public static <D, S> void copyFields(D destination, S source) {
		Stream.of(source.getClass().getDeclaredFields()).forEach(f -> {
			Method getter = findMethodByName(source.getClass(), getFieldGetterName(f));
			Method setter = findMethodByName(destination.getClass(), getFieldSetterName(f));

			try {
				if (Objects.nonNull(getter) && Objects.nonNull(setter)) {
					Object returnValue = getter.invoke(source);
					setValue(destination, getter, setter, returnValue);
				}
			} catch (Exception e) {
				logger.error("copy Fields Error", e);

				throw new UtilException(e);
			}
		});
	}

	private static <D> void setValue(D destination, Method getter, Method setter, Object value)
			throws IllegalAccessException, InvocationTargetException {

		if (Objects.nonNull(value)) {
			setter.invoke(destination, getter.getReturnType().cast(value));
		}
	}

	private static String getFieldGetterName(Field field) {
		String prefix;

		if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
			prefix = IS_PREFIX;
		} else {
			prefix = GET_PREFIX;
		}

		return prefix + capitalizeFirstLetter(field.getName());
	}

	private static String getFieldSetterName(Field field) {
		return SET_PREFIX + capitalizeFirstLetter(field.getName());
	}

	private static String capitalizeFirstLetter(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	private static <T> Method findMethodByName(Class<T> clazz, String name) {
		return Stream.of(clazz.getDeclaredMethods()).filter(m -> name.equals(m.getName())).findAny().orElse(null);
	}
}
