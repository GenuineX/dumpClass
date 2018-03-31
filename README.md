# dumpClass
dump class from JVM

## How to use?
export a jar then,  
```bash
java -cp "./dumpClass.jar:$JAVA_HOME/lib/sa-jdi.jar" com.genuine.dumpclass.DumpClass <pid> <theReferenceOfClass> <outputDir>
```
