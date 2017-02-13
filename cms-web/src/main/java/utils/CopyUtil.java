package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Stream;

public class CopyUtil {
	public static <D, S> void CopyFields(D destination, S source) {
		Stream.of(source.getClass().getDeclaredFields()).forEach(f -> {
			Method getter = findMethodByName(source.getClass(), getFieldGetterName(f));
			Method setter = findMethodByName(destination.getClass(), getFieldSetterName(f));

			try {
				if (Objects.nonNull(getter) && Objects.nonNull(setter)) {
					setter.invoke(destination, getter.getReturnType().cast(getter.invoke(source)));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}

	private static String getFieldGetterName(Field field) {
		String prefix;
		if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
			prefix = "is";
		} else {
			prefix = "get";
		}
		return prefix + capitalizeFirstLetter(field.getName());
	}

	private static String getFieldSetterName(Field field) {
		return "set" + capitalizeFirstLetter(field.getName());
	}

	private static String capitalizeFirstLetter(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	private static <T> Method findMethodByName(Class<T> clazz, String name) {
		return Stream.of(clazz.getDeclaredMethods()).filter(m -> name.equals(m.getName())).findAny().orElse(null);
	}
}
