import java.util.Arrays;

public class Main{
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main (String[] args){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        method1(arr);
        method2(arr);
    }

    private static void actionForArr(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public static void method1(float[] arr){
        long a = System.currentTimeMillis();

        actionForArr(arr);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - a);
    }

    public static void method2(float[] arr) {
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Thread t1 = new Thread( new Runnable()
        {
            @Override
            public void run() {
                System.arraycopy(arr, 0, a1, 0, h);
                actionForArr(a1);
            }
        });
        Thread t2 = new Thread( new Runnable()
        {
            @Override
            public void run() {
                System.arraycopy(arr, h, a2, 0, h);
                actionForArr(a2);
            }
        });

        t1.start();
        t2.start();
       try {
           t1.join();
           t2.join();
       } catch (InterruptedException ex){
           ex.printStackTrace();
       }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - a);
    }

}
