package examples.boot.springboard;

import org.junit.Test;

import java.io.*;

public class JavaIOTest {
    @Test
    public void copy(){
        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream("/DEVEL/ebaykorea3/springboard/src/test/java/examples/boot/springboard/JavaIOTest.java");
            out = new FileOutputStream("/tmp/iofile");

            byte[] buffer = new byte[1024];
            int readCount = 0;

            // 2000 byte
            while((readCount = in.read(buffer)) != -1){
                // buffer배열의 0번째부터 readCount까지 써라.
                out.write(buffer,0, readCount);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // finally
    } // copy method

    @Test
    public void copy2(){

    }
}
