package exercises.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExercises {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat("Stella", 6);
        Field[] catsField = cat.getClass().getDeclaredFields();

        for (Field field : catsField) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(cat, "Jimmy");
            }
        }

        //Ми змінили приватне фінальне поле завдяки рефлексії!!!
        System.out.println(cat.getName());

        Method[] catMethods = cat.getClass().getDeclaredMethods();
        for (Method method : catMethods) {
            if (method.getName().equals("heyThisIsPrivate")) {
                method.setAccessible(true);
                //Ми викликаємо приватний метод до якого не мали доступу!!!
                method.invoke(cat);
            }

            if (method.getName().equals("thisIsAPrivateStaticMethod")) {
                method.setAccessible(true);
                //Ми викликаємо приватний статичний метод до якого не мали доступу!!!
                method.invoke(null);
            }
        }

        //Annotations Examples
        // Cat cat = new Cat("Stella");
        if (cat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("Very important");
        }

        for (Method method : cat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(cat);
                }
            }
        }

        for (Field field : cat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object objectValue = field.get(cat);
                //java 16+
//                if (objectValue instanceof String stringValue) {
//                    System.out.println(stringValue.toUpperCase(Locale.ROOT));
            }
        }
    }
}
