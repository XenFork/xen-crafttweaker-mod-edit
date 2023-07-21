package io.github.xenfork.xcme.forge.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class ZenMethodVisitor extends MethodVisitor {
    private final ClassVisitor cv;


    protected ZenMethodVisitor(int api, MethodVisitor methodVisitor, ClassVisitor cv) {
        super(api, methodVisitor);
        this.cv = cv;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
//        System.out.println(descriptor);
        return super.visitAnnotation(descriptor, visible);
    }
}
