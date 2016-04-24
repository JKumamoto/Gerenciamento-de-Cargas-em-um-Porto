######### MAKEFILE #########

JFLAGS = -g
JC = javac
CLASSPATH = /usr/share/java/mysql-connector-java-5.1.28.jar:.

all: Servidor Cliente
		@echo "Build Pronta"

Registry-Server: Servidor
		rmic Server
		rmiregistry &

Run-Server: 
		java -cp .:mysql-connector-java-5.1.28.jar Server &

default: Requisicao.class Resposta.class Patio.class Carga.class

Servidor: default DAO.class Server.class
		@echo "Build Servidor Pronto"

Cliente: default FormEntradaCarga.class FormSaidaCarga.class Programa.class
		@echo "Build Cliente Pronto"

Requisicao.class: Requisicao.java
		$(JC) $(JFLAGS) Requisicao.java

Resposta.class: Resposta.java
		$(JC) $(JFLAGS) Resposta.java

Patio.class: Patio.java
		$(JC) $(JFLAGS) Patio.java

Carga.class: Carga.java
		$(JC) $(JFLAGS) Carga.java

Server.class: Server.java
		$(JC) $(JFLAGS) Server.java

DAO.class: DAO.java
		$(JC) $(JFLAGS) -cp $(CLASSPATH) DAO.java

FormEntradaCarga.class: FormEntradaCarga.java
		$(JC) $(JFLAGS) FormEntradaCarga.java

FormSaidaCarga.class: FormSaidaCarga.java
		$(JC) $(JFLAGS) FormSaidaCarga.java

Programa.class: Programa.java
		$(JC) $(JFLAGS) Programa.java


###### CLEAN #####
clean:
		rm -rf *.class
		@echo "clean"
