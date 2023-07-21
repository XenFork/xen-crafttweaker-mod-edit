package io.github.xenfork.xcme.forge.asm;

import org.objectweb.asm.*;

import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.ASM9;

public class ZenClassVisitor extends ClassVisitor {
    public static final ArrayList<String> zenRegisterClassName = new ArrayList<>();
    public String className;

    public ZenClassVisitor(int api) {
        super(api);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        className = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    public ZenClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
//        System.out.println(descriptor);
//        System.out.println(descriptor);
        return new ZenAnnotationVisitor(ASM9, super.visitAnnotation(descriptor, visible), cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        return new ZenMethodVisitor(ASM9, super.visitMethod(access, name, descriptor, signature, exceptions), cv);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        return new ZenFieldVisitor(ASM9, super.visitField(access, name, descriptor, signature, value), cv);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
    }
}
