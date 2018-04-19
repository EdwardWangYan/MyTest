package com.ikentop.biz.provider.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author tac
 * @since 09/01/2018
 */
public abstract class IOUtils {
    public static String readToString(InputStream is) throws IOException {
        return readToString(is, "UTF-8");
    }

    public static String readToString(InputStream is, String charsetName) throws IOException {
        return readToString(is, charsetName, 1024);
    }

    public static String readToString(InputStream is, String charsetName, final int bufferSize) throws IOException {
        final char[] buffer = new char[bufferSize];

        InputStreamReader sr = new InputStreamReader(is, charsetName);
        StringBuilder sb = new StringBuilder();
        while (sr.ready()) {
            int rsz = sr.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            sb.append(buffer, 0, rsz);
        }
        return sb.toString();
    }
}
