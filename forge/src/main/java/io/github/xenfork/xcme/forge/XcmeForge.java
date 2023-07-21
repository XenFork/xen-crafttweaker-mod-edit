package io.github.xenfork.xcme.forge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

import static org.objectweb.asm.Opcodes.ASM9;


@Mod(XcmeForge.MOD_ID)
public class XcmeForge {
    public static final String MOD_ID = "xcme";
    public static final Map<String, Path> jarFind = new HashMap<>();
    public XcmeForge() {
        for (ModInfo mod : FMLLoader.getLoadingModList().getMods()) {
            Path filePath = mod.getOwningFile().getFile().getFilePath().toAbsolutePath();
            if (filePath.toString().contains(".jar")) {
                try {
                    try (JarFile jf = new JarFile(filePath.toFile())) {
                        Enumeration<JarEntry> entries = jf.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry jarEntry = entries.nextElement();
                            if (jarEntry.getName().endsWith(".class")) {
//                                System.out.println(jarEntry.getName());

                                ZenClassReader zenClassReader = new ZenClassReader(jf.getInputStream(jarEntry));
                                zenClassReader.accept(new ZenClassVisitor(ASM9), 0);

                            }

                        }
                    }

                } catch (IOException ignored) {

                }
                for (String s : ZenClassVisitor.zenRegisterClassName) {
                    System.out.println(s);
                }
            }
        }
//        for (Path path : FMLPaths.MODSDIR.get()) {
//            try {
//                findPath(path);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
////            System.out.println(path);
//        }
    }

}