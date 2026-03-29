Luis Antonio Ribeiro Tels 
GEC-2223

# Prompt 01: dúvida sobre agregação

## Descrição da tarefa

Neste caso eu queria tirar uma dúvida sobre como criar uma agregação.

Passei como contexto as classes MemoriaUSB e Computador e usei o GitHub Copilot(Auto) como modelo de LLM. 

## Prompt

```
Se você fosse explicar o passo a passo de como criar a agregação, como escreveria?

Escrever que primeiramente crio uma instância de memória USB e depois faço a agregação usando musb como parâmetro de referência está incorreto?
```

## Output

```
ua explicação não está incorreta, mas ela descreve o processo do ponto de vista de quem **usa** as classes (o cliente do código). Para um entendimento completo em POO, precisamos separar o que acontece na **definição da classe** (o molde) e o que acontece na **instanciação** (o uso).

Se eu fosse explicar o passo a passo para criar uma agregação, eu dividiria em duas etapas: **Estrutura** e **Execução**.

---

## Passo 1: Definir a Estrutura (O Molde)

Antes de criar instâncias, você precisa preparar a classe "Todo" para ser capaz de receber e armazenar a "Parte".

1. **Crie a classe Parte:** No seu caso, a classe `MemoriaUSB`. Ela deve ser independente e não precisa saber da existência do computador.
    
2. **Defina o Atributo na classe Todo:** Na classe `Computador`, você deve declarar um atributo do tipo `MemoriaUSB`. É isso que permite ao computador "carregar" a memória.
    
3. **Crie o Ponto de Entrada (Injeção):** Crie um método (como o seu `addMemoriaUSB`) ou um construtor que receba um objeto `MemoriaUSB` pronto.
    

---

## Passo 2: Executar a Agregação (O Uso)

Aqui entra exatamente o que você descreveu. É o momento em que os objetos ganham vida na memória do computador (RAM).

1. **Instancie a Parte:** Você cria o objeto `MemoriaUSB` de forma isolada.
    
    - _Exemplo:_ `MemoriaUSB pendrive = new MemoriaUSB("Kingston", 32);`
        
2. **Instancie o Todo:** Você cria o objeto `Computador`.
    
    - _Exemplo:_ `Computador meuPC = new Computador("Dell", 4500);`
        
3. **Realize a Agregação:** Você passa a referência do `pendrive` para dentro do `meuPC`.
    
    - _Exemplo:_ `meuPC.addMemoriaUSB(pendrive);`
        

---

## Por que sua frase está "meio" certa?

Sua frase: _"Primeiramente crio uma instância de memória USB e depois faço a agregação usando musb como parâmetro de referência"_ está correta sobre **como usar** a agregação.

Porém, para um professor ou em uma prova de POO, o detalhe crucial que falta é: **o objeto `Computador` precisa guardar essa referência em um atributo interno.**

### Onde as pessoas costumam errar:

Se você apenas passa o parâmetro e não faz `this.memoria = musb;` dentro do método, a agregação **não aconteceu**. O computador apenas "viu" a memória passar por ele, mas não a "agregou" à sua estrutura.

> **Regra de Ouro da Agregação:** > O objeto "Parte" (USB) nasce fora do "Todo" (PC), entra no "Todo" via parâmetro, e permanece vivo mesmo se o "Todo" for destruído.

---

### Exemplo de Checklist para você seguir:

- [ ] Tenho uma classe para o **Todo** e uma para a **Parte**?
    
- [ ] O **Todo** tem um atributo para guardar a **Parte**?
    
- [ ] Eu instanciei a **Parte** fora do **Todo**?
    
- [ ] Eu usei um método ou construtor para passar a **Parte** para dentro do **Todo**?
    
- [ ] Eu salvei essa referência no atributo (usando o `this`)?
    

Se você seguiu esses 5 passos, você criou uma agregação perfeita.

Gostaria que eu montasse um exemplo de como seria esse mesmo passo a passo, mas para o relacionamento de **Composição** (onde o PC é quem fabrica a própria memória)?
```
