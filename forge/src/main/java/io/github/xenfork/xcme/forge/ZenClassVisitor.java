package io.github.xenfork.xcme.forge;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;

import java.text.MessageFormat;
import java.util.ArrayList;

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
        if (descriptor.equals(convert(ZenRegister.class))) {
            zenRegisterClassName.add(className);
        }
        return super.visitAnnotation(descriptor, visible);
    }

    public static String convert(Class<?> clazz) {
        return MessageFormat.format("L{0};", clazz.getName().replace(".", "/"));
    }

}
