
set CLASSPATH=..\\lib\\${project.build.finalName}.${packaging};${classpath}

java -cp %CLASSPATH% org.formation.mabiblio.console.MaBiblioConsole