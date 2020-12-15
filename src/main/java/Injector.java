import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector <T> {
    T inject(T someObject) {
        Object object = someObject;
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.getAnnotation(AutoInjectable.class).equals(0)) {
                FileInputStream fis;
                Properties property = new Properties();
                try {
                    fis = new FileInputStream("GetProperties.properties");
                    property.load(fis);
                    if (field.getType().equals(MyInterface1.class)){
                        clazz = Class.forName(property.getProperty("MyInterface1"));
                        field.set(someObject,clazz.newInstance());
                    }
                    if (field.getType().equals(MyInterface2.class)){
                        clazz = Class.forName(property.getProperty("MyInterface2"));
                        field.set(someObject,clazz.newInstance());
                    }
                } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return someObject;
    }
}
