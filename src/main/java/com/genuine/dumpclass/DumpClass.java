package com.genuine.dumpclass;

import com.genuine.dumpclass.constant.DumpClassConstant;

import java.lang.reflect.Method;

public class DumpClass {

    public static void main(String[] args){

        try {
            //load ClassDump
            DumpClass.class.getClassLoader().loadClass(DumpClassConstant.classDump);
            ClassLoader classLoader = DumpClass.class.getClassLoader();

            //get args
            if (args == null || args.length < 3){
                System.out.println("need args.");
                return;
            }
            String pid = args[0];
            String className = args[1];
            String dirPath = args[2];

            //set property
            System.setProperty(DumpClassConstant.filter, DumpClassConstant.packageNameFilter);
            System.setProperty(DumpClassConstant.pkgList, className);
            System.getProperty(DumpClassConstant.outputDir, dirPath);

            //dump class
            Method dumpClassMain = classLoader.loadClass(DumpClassConstant.classDump).getMethod("main", String[].class);
            dumpClassMain.invoke(null,new Object[]{new String[] {pid}});

            System.out.println("dump " + className + "finished");
        }catch (Throwable e){
            System.out.println(e.toString());
        }
    }
}
