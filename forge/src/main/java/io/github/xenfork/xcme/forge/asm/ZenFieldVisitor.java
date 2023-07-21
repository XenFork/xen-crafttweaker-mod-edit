package io.github.xenfork.xcme.forge.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class ZenFieldVisitor extends FieldVisitor {
    private final ClassVisitor cv;

    protected ZenFieldVisitor(int api, FieldVisitor fieldVisitor, ClassVisitor cv) {
        super(api, fieldVisitor);
        this.cv = cv;
    }
}
