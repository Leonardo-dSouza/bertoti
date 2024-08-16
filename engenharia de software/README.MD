# Atividade 1
We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

 O engenheiro de software desenvolve projetos mais complexos e escalaveis, visando o tempo de execução e resposta, a eficiencia e o alto processamento de dados. Por consequência, o mesmo tende a tomar decisões arriscadas e complexas devido as altas transações de dados presentes no software que se alteradas de forma imprecisa, podem prejudicar o projeto como um todo.

Within Google, we sometimes say, “Software engineering is programming integrated over time.” Programming is certainly a significant part of software engineering: after all, programming is how you generate new software in the first place. If you accept this distinction, it also becomes clear that we might need to delineate between programming tasks (development) and software engineering tasks (development, modification, maintenance). The addition of time adds an important new dimension to programming. Cubes aren’t squares, distance isn’t velocity. Software engineering isn’t programming.

No trecho acima, é ressaltado a importancia e a diferença entre o programador e o engenheiro de software, onde o engenheiro deve se preocupar com a escabilidade e a manutenção ao longo do tempo, ressaltando que para o engenheiro de software, nada é utilizavel para tudo, e nada serve para todo o tempo.

# Atividade 2

Python e C 
Com python, por ser uma linguagem de alto nível, o tempo de execulção é maior comparado ao C. 
C é uma linguagem que está muito póxima a linguagem de máquina, acaba sendo mais difícil de ler, compreender e escrever o código. 

Windows e Linux 
Windowns não tem o código aberto, ou seja, você não pode editar ou reforçar a segorança do mesmo, o que pode causar falhas por depender de outros serviços para funcionarem 
Linux tem sua complexidade de adaptação que é uma desvantagem.Isso porque suas tarefas, de maneira geral, acabam sendo pouco intuitivas para a grande maioria dos usuários. 

Android e Ios 
O Desenvolvimento para iOs é difícil e com nicho fechado, nem tudo que você aprende dessa tecnologia é possível parssar para outras. Na verdade, a Apple parece seguuir isso com todas suas vertentes, seja com a programação ou na exclusão de produtos, carregadores e compatibilidade. Então, dentro do âmbito de desenvolvimento de software, muitas coisas não são passadas para outros stacks, como front-end, back-end e dados, por exemplo. 
O maior problema do sistema operacional Android, é a alta variedade de aparelhos que utilizam do mesmo, celulares, relógiom aplicativos de televisão smart, arduíno e etc. Programar para que seja compatível na maior gama de aparelhos e variedades torna o desenvolvimento Android desafiador.

# Atividade 3
![Arquitetura DataBase Discord](https://pbs.twimg.com/media/FrHG_eEaEAALZvd?format=jpg&name=4096x4096)

Em 2015 o discord foi lançado com um único conjunto de réplicas do MongoDB, porém, em novembro do mesmo ano, o Discord teve seus primeiros 100 Milhoes de mensagens armazenadas no banco de dados e os dados e índices não cabiam mais na RAM, a latencia do mesmo se tornou imprevisível.
logo, eles precisavam de um banco de dados que atendesse os requisitos de, principalmente, a escabilidade linear, baixa manutenção e failover automático, pois o mongoDB não estava mais sendo utilizavél.
Mas com o passar do tempo, foi acumulando mais mensagens, e a Cassandra fornece disponibilidade em vez de consistência, ou seja, se dois usuários estão realizando uma ação na mesma mensagem como editá-la e/ou apagar, os usuários recebiam erros na edição.
Em 2022 o Discord alcancou um trilhão de mensagens, e novamente, estava sofrendo do mesmo problema. E dentre os problemas, havia um grande problemas:
Partição Quente, um termo que o discord usa quando há um tráfego alto que chega a uma partição específica, resultando na simultaneidade ilimitada, levando a latencia. Leituras são mais caras que as gravações no Cassandra, então quando há mais leituras e a partição específica fica para trás, causa picos de latência em todas as outras operações. 
E para resolver ustilizaram o ScryllaDB, alternativa da cassandra, mas em c++, que resolveria os problemas em partes, pois as partições foi necessário criar um serviço de dados, uma camada entre o servidor da API e os clusters do banco de dados.
No fim, o Discord teve problemas com a escabilidade do seu aplicativo por conta da quantidade de mensagens armazenadas, e para resolver, tiveram que analisar os trade offs para decidir e melhorar o banco de dados existente.