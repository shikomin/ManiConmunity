package com.wander.core.utils;

import java.io.*;

/**
 * Created by 胥珂铭 on 2019/8/1.
 */
public class FileUtil {

    public static void copyFile(InputStream in, File target){
        OutputStream out = null;
        try {
            out = new FileOutputStream(target);
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b, 0, b.length)) != -1) {
                out.write(b, 0, len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
