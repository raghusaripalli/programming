package codechef.dsa_learning_series.LRNDSA01;

import java.io.DataInputStream;
import java.io.IOException;

public class Carvans {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Reader r = new Reader();
        int total = r.nextInt();
        while (total-- != 0) {
            int n = r.nextInt();
            int minSoFar = Integer.MAX_VALUE;
            int count = 0;
            int currValue;
            while (n-- != 0) {
                currValue = r.nextInt();
                if (currValue <= minSoFar) {
                    minSoFar = currValue;
                    ++count;
                }
            }
            System.out.println(count);
        }
    }
}
