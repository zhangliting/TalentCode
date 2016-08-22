package imooc.annotation;

import java.lang.reflect.Method;

public class ParseAnn {
	public static void main(String[] args) {

		try {
			Class c = Class.forName("imooc.annotation.Person");
			boolean isExist = c.isAnnotationPresent(Description.class);
			if (isExist) {
				Description description = (Description) c.getAnnotation(Description.class);
				System.out.println(description.value());
			}
			Method[] methods = c.getMethods();
			for (Method method : methods) {
				boolean isMethodExist = method.isAnnotationPresent(Description.class);
				if (isMethodExist) {
					Description description = (Description)method.getAnnotation(Description.class);
					System.out.println(description.value());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
