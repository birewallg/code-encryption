package blackwalls;

import java.io.*;

class Transport {

    static byte[] loadFileInByte(String pathname) throws IOException {
        File file = new File(pathname);
        byte[] bytesArray = new byte[(int) file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytesArray); //read file into bytes[]
        fileInputStream.close();

        return bytesArray;
    }

    static void uploadByteInFile(String pathname, byte[] bytesArray) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(pathname);
        fileOutputStream.write(bytesArray);
        fileOutputStream.close();
    }
}
