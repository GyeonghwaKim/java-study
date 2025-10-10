package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {
    public static void main(String[] args) {
        Class<BasicData> hellClass = BasicData.class;

        System.out.println("========== methods() =========");
        Method[] methods = hellClass.getMethods(); //getDeclareMethods()
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println("========== declareMethods() =========");
        Method[] declaredMethods = hellClass.getDeclaredMethods(); //getDeclareMethods()
        for (Method method : declaredMethods) {
            System.out.println("method = " + method);
        }

    }
}
