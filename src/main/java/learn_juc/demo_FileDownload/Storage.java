package learn_juc.demo_FileDownload;

import java.io.Closeable;
import java.io.IOException;

public class Storage implements Closeable, AutoCloseable {

    @Override
    public void close() throws IOException {

    }
}
