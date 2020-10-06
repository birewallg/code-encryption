package blackwalls;

class Encryption {

    static byte[] encryption(byte[] input, String secretkey) {
        int secret = secretkey.getBytes().length + sand(secretkey.getBytes().length);
        byte[] output = input.clone();

        for (int i = 0; i <= output.length - 4; ++i) {
            writeInt(output, i, readInt(output, i) + secret);
        }

        return output;
    }

    static byte[] decryption(byte[] input, String secretkey) {
        int secret = secretkey.getBytes().length + sand(secretkey.getBytes().length);
        byte[] output = input.clone();

        for (int i = output.length - 4; i >= 0; --i) {
            writeInt(output, i, readInt(output, i) - secret);
        }

        return output;
    }

    private static int sand(int sand){
        sand = sand >> 4 | sand << 4 | sand << 2 | sand >> 2;
        System.out.println("sand = " + sand);
        return sand;
    }

    private static void writeInt(byte[] data, int offset, int value) {
        data[offset] = (byte)(value & 0xff);
        data[offset + 1] = (byte)((value >>> 8) & 0xff);
        data[offset + 2] = (byte)((value >>> 16) & 0xff);
        data[offset + 3] = (byte)((value >>> 24) & 0xff);
    }
    private static int readInt(byte[] data, int offset) {
        int b0 = Byte.toUnsignedInt(data[offset]);
        int b1 = Byte.toUnsignedInt(data[offset + 1]);
        int b2 = Byte.toUnsignedInt(data[offset + 2]);
        int b3 = Byte.toUnsignedInt(data[offset + 3]);

        return (b3 << 24) | (b2 << 16) | (b1 << 8) | b0;
    }

}
