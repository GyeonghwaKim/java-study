package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //정적 메서드 호출
        BasicData hellInstance = new BasicData();
        hellInstance.call();

        //동적 메서드 호출
        Class<? extends BasicData> helloClass = hellInstance.getClass();
        String methodName = "hello";

        Method method = helloClass.getDeclaredMethod(methodName, String.class);
        Object returnValue = method.invoke(helloClass, "hi");
        //Object returnValue = method.invoke(hellInstance, "hi");
        System.out.println("returnValue = " + returnValue);
    }
}
