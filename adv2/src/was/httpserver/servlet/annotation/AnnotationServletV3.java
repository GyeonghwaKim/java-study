package was.httpserver.servlet.annotation;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationServletV3 implements HttpServlet {

    private final Map<String, ControllerMethod> pathMap;

    public AnnotationServletV3(List<Object> controllers) {
        this.pathMap = new HashMap<>();
        initializePathMap(controllers);
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path =   request.getPath();
        ControllerMethod controllerMethod = pathMap.get(path);

        if (controllerMethod == null) {
            throw new PageNotFoundException("request=" + path);
        }

        controllerMethod.invoke(request,response);
    }

    private void initializePathMap(List<Object> controllers) {
        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Mapping.class)) {
                    String path = method.getAnnotation(Mapping.class).value();
                    if (pathMap.containsKey(path)) {
                        ControllerMethod controllerMethod = pathMap.get(path);
                        throw new IllegalArgumentException("이미 등록된 메서드입니당");
                    }
                    pathMap.put(path, new ControllerMethod(controller, method));
                }
            }
        }
    }

    private static class ControllerMethod {
        private final Object controller;
        private final Method method;

        public ControllerMethod(Object controller, Method method) {
            this.controller = controller;
            this.method = method;
        }

        public void invoke(HttpRequest request, HttpResponse response) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] args = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                if(parameterTypes[i] == HttpRequest.class){
                    args[i] =request;
                }else if(parameterTypes[i] == HttpResponse.class){
                    args[i] =response;
                }else{
                    throw new IllegalArgumentException("지원안하는 파라미터입니당~");
                }
            }

            try {
                method.invoke(controller,args);
            } catch (IllegalAccessException|InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
