# Conta Teste - Cucumber

## Descrição
Exercício desenvolvido na linaguagem Java junto com o o framework Cucumber e Junit, afins de entender os testes durante o desenvolvimento.

# Capturas do teste usando o Cucumber

## Cliente Especial
> Obs: private boolean clienteEspecial = true;
> ![image](https://user-images.githubusercontent.com/38986134/202322136-0add3f09-2396-44e5-bdee-b3b42b0425b1.png)


## Cliente Comum
> Obs: private boolean clienteEspecial = false;
![image](https://user-images.githubusercontent.com/38986134/202322062-6ec74141-a4d3-45b6-89c2-48306e81cedd.png)


# Capturas do teste usando o Junit

## Cliente Especial
![image](https://user-images.githubusercontent.com/38986134/202322333-4d089661-40c6-461d-b170-1a6166407d28.png)

## Cliente Comum
![image](https://user-images.githubusercontent.com/38986134/202322408-6a245233-4116-4e87-aaa2-4d7e34d27d67.png)

# Opções da classe Runner Junit
```java
@CucumberOptions(
  plugin = "pretty", 
  monochrome = true, 
  snippets = SnippetType.CAMELCASE, 
  dryRun = false, 
  strict = true)
```

# Especificação do dryRun:
> Se você quiser verificar se todas as etapas do arquivo de recurso têm definições, você pode precisa ativar o `dryRun = true`
> Ref: https://cucumber.io/docs/cucumber/api/?lang=java

# Especificação do strict:

## última Atualização
> 16/11/2022
