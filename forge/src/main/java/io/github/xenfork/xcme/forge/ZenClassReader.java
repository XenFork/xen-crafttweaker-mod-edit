package io.github.xenfork.xcme.forge;

import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;

public class ZenClassReader extends ClassReader {
    public ZenClassReader(InputStream inputStream) throws IOException {
        super(inputStream);
    }
}
