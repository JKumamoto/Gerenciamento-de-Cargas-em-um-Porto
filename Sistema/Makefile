######### MAKEFILE #########

CLASSPATH = .:mysql-connector-java-5.1.28.jar
JFLAGS = -g -cp $(CLASSPATH)
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Requisicao.java	\
		Resposta.java	\
		Carga.java	\
		Funcionario.java

SERVIDOR = \
		Patio.java	\
		Server.java	\
		DAO.java

TELAS = \
		FormEntradaCarga.java	\
		FormSaidaCarga.java	\
		FormNovoFunc.java	\
		FormUpFunc.java	\
		Programa.java	\
		TelaLogin.java


all: Servidor Cliente
		@echo "Build Pronta"

default: classes

Servidor: default servidor
		@echo "Build Servidor Pronto"

Cliente: default telas
		@echo "Build Cliente Pronto"

classes: $(CLASSES:.java=.class)

servidor: $(SERVIDOR:.java=.class)

telas: $(TELAS:.java=.class)

Registry-Server: 
		rmic Server
		rmiregistry &

Run-Server: 
		java -cp $(CLASSPATH) Server
		
Run-Cliente: 
		java TelaLogin

###### CLEAN #####
clean:	
		rm -rf *.class
		@echo "clean"
