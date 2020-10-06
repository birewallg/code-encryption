package blackwalls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        try {
            byte[] byteArray;
            String filepath = args[0];
            boolean operation = (filepath.contains(".sec"));

            byteArray = Transport.loadFileInByte(filepath);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter secret key: ");
            String key = reader.readLine();

            /* crypt */
            byteArray = (operation) ? Encryption.encryption(byteArray, key) : Encryption.decryption(byteArray, key);

            filepath = (operation) ? filepath.substring(0, filepath.length() - 4) : filepath + ".sec";

            Transport.uploadByteInFile(filepath, byteArray);

            System.out.println("Done!");
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.print("failed! File is not found!");
        }
    }
}
