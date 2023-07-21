package io.github.xenfork.xcme.forge.asm;

import org.objectweb.asm.*;

public class ZenAnnotationVisitor extends AnnotationVisitor {
    private FieldVisitor fv;
    private MethodVisitor mv;
    private ClassVisitor cv;
    public ZenAnnotationVisitor(int api, AnnotationVisitor annotationVisitor, MethodVisitor mv) {
        super(api, annotationVisitor);
        this.mv = mv;
    }

    public ZenAnnotationVisitor(int api, AnnotationVisitor annotationVisitor, ClassVisitor cv) {
        super(api, annotationVisitor);
        this.cv = cv;
    }

    public ZenAnnotationVisitor(int api, AnnotationVisitor annotationVisitor, FieldVisitor fv) {
        super(api, annotationVisitor);
        this.fv = fv;
    }



    @Override
    public void visit(String name, Object value) {
        super.visit(name, value);
    }
}
