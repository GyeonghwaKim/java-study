package reflection;

import reflection.data.BasicData;

public class BasicV1 {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<BasicData> basicDataClass1 = BasicData.class;
        System.out.println("basicDataClass1 = " + basicDataClass1);

        BasicData basicInstance = new BasicData();
        Class<? extends BasicData> basicDataClass2 = basicInstance.getClass();
        System.out.println("basicDataClass2 = " + basicDataClass2);

        Class<?> basicDataClass3 = Class.forName("reflection.data.BasicData");
        System.out.println("basicDataClass3 = " + basicDataClass3);
    }
}
