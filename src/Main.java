import java.util.*;

public class Main {

    static List<Ouvinte> listaOuvinte;
    static Scanner in = new Scanner(System.in);
    static int idOuvinte = 1;
    static int [] apostas = new int[3];


    public static void main(String[] args) {
     /*A “Anabela de Malhadas” queria acertar o valor do peso do saco, mas confundiu-se! No "Jogo do Saco", programa da Rádio
     Brigantia, em Bragança, apresentado pelo locutor Sidónio Costa, era, diariamente, pedido aos ouvintes que acertassem o
     peso de um saco com alguma coisa dentro. Em cada programa era dada aos ouvintes uma margem de 150g (ex.: entre
     4,200kg e 4,350kg) para acertarem no peso do saco. Vídeo: https://www.youtube.com/watch?v=hIrRNFa8OiA
     Faça uma aplicação que permita aos ouvintes jogar no “Jogo do Saco”. Implemente as seguintes opções:
     1. Criar, editar e eliminar ouvintes.
     2. Ver dados de um ouvinte.
     3. Ver ranking de ouvintes (número de vezes que jogaram e número de vezes que acertaram).
     4. Jogar.
     Em cada jogo devem ser selecionados de forma aleatória quais os ouvintes que vão jogar e a sua ordem. Em cada jogo o
     vencedor será o que se aproximar mais do valor do peso do saco.
      */

        listaOuvinte = new ArrayList<>();

        InicializarOuvintes();

        int opcao = 1;

        while (opcao != 0) {
            System.out.println("Bem vindo ao JOGO DO SACO! \nO objetivo e acertar no peso de um saco. Tem uma margem de erro de 150g.");
            System.out.println("1: Criar ouvintes");
            System.out.println("2: Editar dados dos ouvintes");
            System.out.println("3: Ver dados dos ouvintes");
            System.out.println("4: Eliminar ouvintes");
            System.out.println("5: Visualizar ranking dos ouvintes");
            System.out.println("6: Jogar");
            System.out.println("0: Sair");
            opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Sair");
                    break;
                case 1:
                    CriarOuvintes();
                    break;
                case 2:
                    EditarOuvintes();
                    break;
                case 3:
                    VerDadosOuvintes();
                    break;
                case 4:
                    EliminarOuvintes();
                    break;
                case 5:
                    VisualizarRanking();
                    break;
                case 6:
                    Jogar();
                    break;
                default:
                    System.out.println("Opcao invalidaa");
                    return;
            }
        }

    }

    private static void CriarOuvintes() {
        in = new Scanner(System.in);

        System.out.println("Qual o nome do novo ouvinte?");
        String nome = in.next();

        System.out.println("Qual a idade do novo ouvinte?");
        int idade = in.nextInt();

        System.out.println("De que localidade e o novo ouvinte?");
        String localidade = in.next();

        listaOuvinte.add(new Ouvinte(idOuvinte, nome, idade, localidade, 0, 0));
        idOuvinte++;

        System.out.println("Ouvinte adicionado com sucesso.");
    }

    private static void EditarOuvintes() {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < listaOuvinte.size(); i++) {
            System.out.println(listaOuvinte.get(i));
        }

        System.out.println("Qual o ID do Ouvinte que quer editar?");
        int numID = in.nextInt();

        for (int i = 0; i < listaOuvinte.size(); i++) {
            if (numID == listaOuvinte.get(i).getId()) {
                System.out.println("Que informacao quer editar? \n1:Nome \n2:Idade \n3:Localidade");
                int opcao = in.nextInt();

                if (opcao == 1) {
                    System.out.println("Edite o nome");
                    String nome = in.next();
                    listaOuvinte.get(i).setNome(nome);
                    System.out.println("Nome editado com sucesso");
                } else if (opcao == 2) {
                    System.out.println("Edite a idade");
                    int idade = in.nextInt();
                    listaOuvinte.get(i).setIdade(idade);
                    System.out.println("Idade editada com sucesso");
                } else if (opcao == 3) {
                    System.out.println("Edite a localidade");
                    String localidade = in.next();
                    listaOuvinte.get(i).setLocalidade(localidade);
                    System.out.println("Localidade editada com sucesso");
                } else {
                    System.out.println("Opcao invalida");
                    return;
                }
                return;
            }
        }
        System.out.println("Nao existe um Ouvinte com este ID");

    }

    private static void VerDadosOuvintes() {
        System.out.println("Quer consultar um ouvir em particular? \n1: Sim \n2: Nao");
        int opcao = in.nextInt();

        if (opcao == 1) {
            System.out.println("Qual o ID do Ouvinte que quer consultar?");
            int numID = in.nextInt();

            for (int i = 0; i < listaOuvinte.size(); i++) {
                if (numID == listaOuvinte.get(i).getId()) {
                    System.out.println(listaOuvinte.get(i).toString());
                }
            }
        } else if (opcao == 2) {
            for (int i = 0; i < listaOuvinte.size(); i++) {
                System.out.println(listaOuvinte.get(i));
                System.out.println("------------------------");
            }
        } else {
            System.out.println("Nao existe nenhum Ouvinte com esse ID");
        }
    }

    private static void EliminarOuvintes() {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < listaOuvinte.size(); i++) {
            System.out.println(listaOuvinte.get(i));
        }

        System.out.println("Qual o ID do Ouvinte que quer eliminar?");
        int numID = in.nextInt();

        for (int i = 0; i < listaOuvinte.size(); i++) {
            if (numID == listaOuvinte.get(i).getId()) {
                listaOuvinte.remove(i);
                System.out.println("Ouvinte eliminado com sucesso");
                return;
            }
        }
        System.out.println("Nao existe um Ouvinte com este ID");
    }

    private static void VisualizarRanking() {

        // Ordenação decrescente do nr de acertos

        for (int i = 0; i < listaOuvinte.size(); i++) {
            for (int j = i + 1; j < listaOuvinte.size(); j++) {
                if (listaOuvinte.get(i).getNrAcertos() < listaOuvinte.get(j).getNrAcertos()) {

                    Collections.swap(listaOuvinte, i, j);
                }
            }
            System.out.println(listaOuvinte.get(i).toString() + "\nAcertos: " + listaOuvinte.get(i).getNrAcertos() + "\nJogadas: " + listaOuvinte.get(i).getNrJogadas());
            System.out.println("-------------------------");
        }

    }

    private static void Jogar() {

        Random rnd = new Random();

        int nrJogadores = 3;

        // variaveis para encontrar limite inferior e superior, para gerar valor random do peso do saco.
        int pesoMinimo = 500;
        int pesoMaximo = 5000;
        int limInferiorPesoSaco = 0;
        int limSuperiorPesoSaco = limInferiorPesoSaco + 150;
        int pesoSaco;


        System.out.println("Bem vindo ao JOGO DO SACO! \nO objetivo e acertar no peso de um saco. Tem uma margem de erro de 150g.");
        System.out.println("");
        System.out.println("Os ouvintes que vao hoje a jogo sao...");
        System.out.println("...\n...\n...");

        Collections.shuffle(listaOuvinte);

        for (int i = 0; i < nrJogadores; i++) {
            System.out.println("Em " + (i + 1) + " º lugar o(a) " + listaOuvinte.get(i).getNome());
        }

        // Gerar valor random do peso do saco
        limInferiorPesoSaco = rnd.nextInt(pesoMinimo, pesoMaximo);
        limSuperiorPesoSaco = limInferiorPesoSaco + 150;
        pesoSaco = rnd.nextInt(limInferiorPesoSaco, limSuperiorPesoSaco);


        System.out.println("");
        System.out.println("Caros Ouvintes, o saco pesa entre " + limInferiorPesoSaco + "gr e " + limSuperiorPesoSaco + "gr.");
        System.out.println("Digam o valor do saco, em gramas. Por exemplo: 1150gr");
        System.out.println("");

        for (int i = 0; i < nrJogadores; i++) {
            int aposta = 0;
            System.out.println(listaOuvinte.get(i).getNome() + ": Qual e a sua aposta?");
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                aposta = in.nextInt();
            }else{
                System.out.println("Valor errado. Introduza um numero inteiro.");
            }

            boolean apostaRepetida = false;
            if (aposta >= limInferiorPesoSaco && aposta <= limSuperiorPesoSaco) {
            for (int j = 0; j < nrJogadores; j++) {
                if (aposta == apostas[j]) {
                    System.out.println("Esta aposta ja saiu. Tente outra aposta");
                    apostaRepetida = true;
                    i--;
                    break;
                }

            } if(!apostaRepetida){
                    apostas[i] = aposta;
                    listaOuvinte.get(i).setNrJogadas(listaOuvinte.get(i).getNrJogadas() + 1);
                }

            } else {
                System.out.println("Aposte num valor entre " + limInferiorPesoSaco + " e " + limSuperiorPesoSaco);
                i--;
            }
        }

        for (int i = 0; i < nrJogadores; i++) {
            System.out.println("0(A) " + listaOuvinte.get(i).getNome() + " diz que o saco tem " + apostas[i] + "gr.");
        }

        // Verificar qual o valor mais aproximado ao valor do saco
        int distance = Math.abs(apostas[0] - pesoSaco);
        int index = 0;
        for (int i = 1; i < apostas.length; i++) {
            int cdistance = Math.abs(apostas[i] - pesoSaco);
            if (cdistance < distance) {
                index = i;
                distance = cdistance;
            }
        }
        int melhorAposta = apostas[index];
        System.out.println("-----------------------------------------");
        System.out.println("O peso do Saco e " + pesoSaco + "gr.");
        System.out.println("O peso mais aproximado do peso do Saco e " + melhorAposta + "gr. \nO(A) GRANDE VENCEDOR(A) e o(a)" + listaOuvinte.get(index).getNome() + ".");
        System.out.println("-----------------------------------------");

        listaOuvinte.get(index).setNrAcertos(listaOuvinte.get(index).getNrAcertos()+1); //Incrementa o nr de acertos

    }

    private static void InicializarOuvintes() {
        //Lista ouvintes

        listaOuvinte.add(new Ouvinte(1, "Anabela", 40, "Malhadas", 0, 0)); // 0
        listaOuvinte.add(new Ouvinte(2, "Antonio", 53, "Espinhosela", 0, 0)); // 1
        listaOuvinte.add(new Ouvinte(3, "Maria", 62, "Carragosa", 0, 0)); // 2
        listaOuvinte.add(new Ouvinte(4, "Manuel", 55, "Malhadas", 0, 0)); // 3
        listaOuvinte.add(new Ouvinte(5, "Gloria", 55, "Alfaiao", 0, 0)); // 4
        listaOuvinte.add(new Ouvinte(6, "Armando", 72, "Espinhosela", 0, 0)); // 5
        listaOuvinte.add(new Ouvinte(7, "Fatima", 41, "Nogueira", 0, 0)); // 6
        listaOuvinte.add(new Ouvinte(8, "Adalberto", 67, "Rebordaos", 0, 0)); // 7
        listaOuvinte.add(new Ouvinte(9, "Adelaide", 48, "Malhadas", 0, 0)); // 8
        listaOuvinte.add(new Ouvinte(10, "Agostinho", 66, "Rebordaos", 0, 0)); // 9

        idOuvinte = 11;

    }
}