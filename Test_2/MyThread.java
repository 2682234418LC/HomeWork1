package Test_2;

import java.io.*;


public class MyThread extends Thread{
    public static void main(String[] args) throws FileNotFoundException {
        MyThread A = new MyThread("A", 0);
        MyThread B = new MyThread("B", 32);
        A.start();
        B.start();
    }

    //定义文件读取的游标位置
    private int start;
    //每次读取的字节数
    private int len = 32;
    private RandomAccessFile raf, raf_copy;
    private File file = new File("E://HomeWork/src/Test_2/Property");
    private File copy_file = new File("E://HomeWork/src/Test_2/Property1");

    public MyThread(String name, int start) throws FileNotFoundException {
        this.start = start;
        this.setName(name);
        raf = new RandomAccessFile(file, "r");
        raf_copy = new RandomAccessFile(copy_file, "rw");
    }

    @Override
    synchronized public void run() {
        while (true) {
            try {
                byte[] b = new byte[len];
                raf.seek(start);
                int read = raf.read(b);
                //把读取到的内容存储到另一个文件中
                if (read == -1) {
                    return;
                }
                //设置游标下移继续读取文件内容
                start += len*2;
                System.out.println("由" + this.getName() + "获得到：" + new String(b));
                raf_copy.write(b);
                sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
