# Gerenciamento-de-Cargas-em-um-Porto

Projeto da Disciplina Engenharia de Software.

* Contexto do Sistema.

> Um porto trabalha com a logística de cargas. Há dois cais, um onde os navios descarregam e outro no qual eles são carregados. Além disso, existem duas entradas de caminhão, uma para cargas e a outra para descargas. Para o armazenamento das cargas, é utilizado um pátio central, no qual atuam um conjunto de empilhadeiras para movimentação das cargas. Estas são padronizadas em containers iguais. Cada carga é identificada por uma data de entrada, uma data de saída, um tempo de estocagem previsto, uma posição (endereço) no pátio, um remetente e um destinatário, o dono da carga, o local de entrada e o local de saída (barco ou caminhão). Quando uma carga chega é registrado no sistema o local de onde ela veio e uma data de entrada. O sistema gera uma etiqueta (rastreador) com o identificador de carga (ID) e uma posição específica no pátio que depende do tempo previsto de estocagem e da disponibilidade de vagas. A carga é etiquetada e armazenada na sua devida posição. Quando a carga sai, é marcado no sistema a data de saída, por onde ela foi retirada e o espaço no pátio que fica vazio para estocagem.

> Como a capacidade do pátio é limitada, sempre que não houver espaço para cargas, o porto fica interditado para entrada de cargas. Além disso, o sistema armazena as informações para todas as cargas que já passaram por ele.

> O sistema também prevê um controle de acesso ao funcionários. Estes devem ter login e senha cadastrados antes de poderem acessar o sistema. Com isso, um funcionário poderá acessar o sistema a partir de seu terminal de trabalho. Quando uma carga chega, um funcionário de carga/descarga cadastra sua entrada no porto. Quando uma carga é retirada, o mesmo tipo de funcionário cadastra sua saída do porto. A qualquer momento, um funcionário com permissão de acesso ao sistema, pode consultar as cargas registradas que estão ou já estiveram no porto. Os funcionários são cadastrados no sistema pelos funcionários administrativos que tem, além de acesso ao gerenciamento de cargas, também acesso ao gerenciamento de usuários do sistema. Estes usuários podem cadastrar novos usuários e alterar dados de cargas já registradas caso haja problemas nos dados informados inicialmente. Um usuário administrativo tem acesso ao dados de todos os usuários menos daqueles que também são administrativos. 


## Incremento 1

O incremento 1 contém as operações básicas do sistema, o registro de entrada e saída de carga.

### Compilando e Rodando

1. Script SQL na pasta Banco (Inicialização do Banco de Dados).

2. Makefile na pasta Sistema.
	* make: compilar tudo.
	* Registry-Server: compilar o servidor e registrar o rmi.
	* Run-Server: rodar o servidor.
	* Run-Cliente: rodar o cliente.
	* clean: Limpar a pasta.

