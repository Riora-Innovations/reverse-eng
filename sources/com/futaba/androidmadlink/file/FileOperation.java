package com.futaba.androidmadlink.file;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
    public static File openFile(String filename) {
        File ofe = null;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            File ofe2 = new File(filename);
            try {
                if (ofe2.exists()) {
                    return ofe2;
                }
                ofe2.createNewFile();
                return ofe2;
            } catch (IOException e) {
                e = e;
                ofe = ofe2;
                e.printStackTrace();
                return ofe;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            return ofe;
        }
    }

    public static boolean saveFile(File file, String inStr) {
        try {
            FileWriter fo = new FileWriter(file, true);
            fo.write(inStr);
            fo.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
