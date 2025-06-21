## Compilador
- Transforma um codigo de uma linguagem para codigo de outra linguagem

### Principais tópicos
    - precisa unir várias bibliotecas para funcionar
    - precisa juntar tudo antes, para então gerar o novo código
### Exigencias
    - Gerar código correto
    - Tratar programas de qualquer tamanho
    - Não é essencial que a velocidade da compilação seja rápida
    - o tamanho do compilador não é problema
    - *As mensagens de erro devem possuir boa qualidade*
    - Velocidade e codigo gerado dependem do propósito do compilador, onde
    a velocidade deve vir primeiro.

### Etapas principais
    1. Analise léxica (função de um sistema de "soletrar")
    2. Análise sintática (funcão de análise gramatical)
    3. Análise semântica (funcao de verificar a congruencia das operações)
    4. Geração de código intermediário (alocação de memória)
    5. Otimizador de código
    6. Gerador de código final

### Estruturas de apoio
    - Tabelas ou variáveis de simbolo
    - Tabela de palavras/simbolos reservados
    - tabelas de escopo dos nomes que estão sendo utilizados
    - Manipulação de erros

### Exemplo
####  Análise léxica
    - Utiliza RegEx e automatos
    - Quebra a linha em termos (tokens)
    x:=x+y*2 =>
    ```
        <x, id1> <:=,:=> <x,id1> <+,op> <y,id2> <*,op> <2,num>
    ```
#### Análise sintatica
    - verificação da validade da formação
    - Gramática livre de contexto
    ```
        comando_atribuicao => id1 := expressao
        expressao => id1 op id2 op num
    ```
#### Análise semântica
    - verifica se uso foi adequado
    - variaveis foram declaradas? o tipo é compatível?
    ```
       (id1)_int:=(id1 op id2 num)_int
       busca_tabela_simbolos(id1)=true
       busca_tabela_simbolos(id2)=true
    ```
#### geração de código intermediário
    - após análise, posso começar a qurbrar o codigo em etapas intermediarias
    ```
        temp1 := id2 * 2
        temp2 := id1 + temp1
        id1 := temp2
    ```
#### Otimização do codigo
    - temos que pensar em performance, economizando ciclos
    ```
        temp1 := id2 * 2
        id1 := id1 + temp1
    ```
#### Geracao do codigo
    - geração do assembly de fato

### Outros programas relacionados
    - Interpretadores: fazem a análise em tempo de execução
    - Assemblers: traduzem a linguagem de montagem para codigo de máquina
    - Editores: Onde o código é de fato escrito
    - Depuradores: Programas que determinam *erros de execução* em um programa compilado

### Interpretadores X Compiladores
    - Ambos são tradutores de linguagens
##### Interpretadores
    - Executa o programa fonte de imediato
    - são menores que compiladores
    - mais adaptáveis a diferentes ambientes computacionais
    - tempo de execução maior (instrucoes são armazenadas e executadas sempre)
    - Python, Javascript, Go, ShellScript
##### Compiladores
    - Gera um codigo objeto, executado apos traducao
    - Compila so uma vez executando n vezes
    - tempo de execução é menor
    - C, Rust
##### Linguagens hibridas
    - Java / C# : Compilada em codigo virtual intermediário e então interpretado pela VM
