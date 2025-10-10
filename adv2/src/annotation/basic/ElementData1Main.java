package annotation.basic;

import java.util.Arrays;

public class ElementData1Main {
    public static void main(String[] args) {
        Class<ElementData1> annoClass = ElementData1.class;
        AnnoElement annotation = annoClass.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        int count = annotation.count();
        String[] tags = annotation.tags();

        System.out.printf("value = %s, count = %d, tags = %s",value,count, Arrays.toString(tags));


    }
}
