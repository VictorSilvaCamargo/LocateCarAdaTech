import java.util.Scanner;

import Classes.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeiculoRepository veiculoRepository = new VeiculoRepository();
        PessoaFisicaRepository pessoaFisicaRepository = new PessoaFisicaRepository();
        PessoaJuridicaRepository pessoaJuridicaRepository = new PessoaJuridicaRepository();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Cadastrar Pessoa Física");
            System.out.println("3. Cadastrar Pessoa Jurídica");
            System.out.println("4. Imprimir Lista de Veículos");
            System.out.println("5. Imprimir Lista de Pessoas Físicas");
            System.out.println("6. Imprimir Lista de Pessoas Jurídicas");
            System.out.println("0. Encerrar o programa");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Informe o nome do veículo:");
                    scanner.nextLine();
                    String nomeVeiculo = scanner.nextLine();
                    System.out.println("Informe a placa do veículo:");
                    String placaVeiculo = scanner.nextLine();
                    System.out.println("Informe o tipo de veículo (PEQUENO, MEDIO ou SUV):");
                    String tipoVeiculo = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(nomeVeiculo, placaVeiculo, tipoVeiculo);
                    veiculoRepository.adicionarVeiculo(veiculo);
                }
                case 2 -> {
                    System.out.println("Informe o nome da pessoa física:");
                    scanner.nextLine();
                    String nomePessoaFisica = scanner.nextLine();
                    System.out.println("Informe o sobrenome da pessoa física:");
                    String sobrenomePessoaFisica = scanner.nextLine();
                    System.out.println("Informe o CPF da pessoa física:");
                    String cpfPessoaFisica = scanner.nextLine();

                    if (!pessoaFisicaRepository.verificarCPF(cpfPessoaFisica)) {
                        PessoaFisica pessoaFisica = new PessoaFisica(nomePessoaFisica, sobrenomePessoaFisica, cpfPessoaFisica);
                        pessoaFisicaRepository.adicionarPessoaFisica(pessoaFisica);

                    } else {
                        System.out.println("CPF ja cadastrado.");
                    }


                }
                case 3 -> {
                    System.out.println("Informe o nome da pessoa jurídica:");
                    scanner.nextLine(); // Consumir a nova linha pendente
                    String nomePessoaJuridica = scanner.nextLine();
                    System.out.println("Informe o sobrenome da pessoa jurídica:");
                    String sobrenomePessoaJuridica = scanner.nextLine();
                    System.out.println("Informe o CNPJ da pessoa jurídica:");
                    String cnpjPessoaJuridica = scanner.nextLine();
                    if (!pessoaJuridicaRepository.verificarCNPJ(cnpjPessoaJuridica)) {
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(nomePessoaJuridica, sobrenomePessoaJuridica, cnpjPessoaJuridica);
                        pessoaJuridicaRepository.adicionarPessoaJuridica(pessoaJuridica);

                    } else {
                        System.out.println("CNPJ ja cadastrado.");
                    }

                }
                case 4 -> {
                    System.out.println("Informe o nome do veículo a ser buscado:");
                    scanner.nextLine(); // Consumir a nova linha pendente
                    String nomeVeiculoBusca = scanner.nextLine();

                    Veiculo veiculoEncontrado = veiculoRepository.encontrarVeiculoPorNome(nomeVeiculoBusca);

                    if (veiculoEncontrado != null) {
                        System.out.println("Veículo encontrado:");
                        System.out.println("Nome: " + veiculoEncontrado.getNome());
                        System.out.println("Placa: " + veiculoEncontrado.getPlaca());
                        System.out.println("Tipo: " + veiculoEncontrado.getTipo());
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                }

                case 5 -> pessoaFisicaRepository.imprimirPessoasFisicas();
                case 6 -> pessoaJuridicaRepository.imprimirPessoasJuridicas();
                // Dentro do loop switch (opcao)
                case 7 -> {
                    System.out.println("Escolha uma opção de atualização:");
                    System.out.println("1. Atualizar Pessoa Física");
                    System.out.println("2. Atualizar Pessoa Jurídica");
                    System.out.println("3. Atualizar Veículo");
                    int opcaoAtualizacao = scanner.nextInt();

                    scanner.nextLine(); // Consumir a nova linha pendente

                    if (opcaoAtualizacao == 1) {
                        System.out.println("Informe o CPF da pessoa física a ser atualizada:");
                        String cpfExistente = scanner.nextLine();

                        System.out.println("Informe o novo nome da pessoa física:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Informe o novo sobrenome da pessoa física:");
                        String novoSobrenome = scanner.nextLine();

                        // Buscar Pessoa Física por CPF
                        BuscadorPessoaFisicaImpl buscadorPessoaFisica = new BuscadorPessoaFisicaImpl(pessoaFisicaRepository);
                        AtualizadorPessoaFisicaImpl atualizadorPessoaFisica = new AtualizadorPessoaFisicaImpl(buscadorPessoaFisica);
                        boolean atualizado = atualizadorPessoaFisica.atualizarPessoaFisica(cpfExistente, novoNome, novoSobrenome);

                        if (atualizado) {
                            System.out.println("Cadastro de Pessoa Física atualizado com sucesso.");
                        } else {
                            System.out.println("Erro ao atualizar o cadastro de Pessoa Física.");
                        }
                    } else if (opcaoAtualizacao == 2) {
                        System.out.println("Informe o CNPJ da pessoa jurídica a ser atualizada:");
                        String cnpjExistente = scanner.nextLine();

                        System.out.println("Informe o novo nome da pessoa jurídica:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Informe o novo sobrenome da pessoa jurídica:");
                        String novoSobrenome = scanner.nextLine();

                        // Buscar Pessoa Jurídica por CNPJ
                        BuscadorPessoaJuridicaImpl buscadorPessoaJuridica = new BuscadorPessoaJuridicaImpl(pessoaJuridicaRepository);
                        AtualizadorPessoaJuridicaImpl atualizadorPessoaJuridica = new AtualizadorPessoaJuridicaImpl(buscadorPessoaJuridica);
                        boolean atualizado = atualizadorPessoaJuridica.atualizarPessoaJuridica(cnpjExistente, novoNome, novoSobrenome);

                        if (atualizado) {
                            System.out.println("Cadastro de Pessoa Jurídica atualizado com sucesso.");
                        } else {
                            System.out.println("Erro ao atualizar o cadastro de Pessoa Jurídica.");
                        }
                    } else if (opcaoAtualizacao == 3) {
                        System.out.println("Informe a placa do veículo a ser atualizado:");
                        String placaExistente = scanner.nextLine();

                        System.out.println("Informe o novo nome do veículo:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Informe o novo tipo do veículo:");
                        String novoTipo = scanner.nextLine();

                        // Buscar Veículo por placa
                        BuscadorVeiculoImpl buscadorVeiculo = new BuscadorVeiculoImpl(veiculoRepository);
                        AtualizadorVeiculoImpl atualizadorVeiculo = new AtualizadorVeiculoImpl(buscadorVeiculo);
                        boolean atualizado = atualizadorVeiculo.atualizarVeiculo(placaExistente, novoNome, novoTipo);

                        if (atualizado) {
                            System.out.println("Cadastro de Veículo atualizado com sucesso.");
                        } else {
                            System.out.println("Erro ao atualizar o cadastro de Veículo.");
                        }
                    } else {
                        System.out.println("Opção de atualização inválida.");
                    }
                    break;
                }

            }
        }
    }
}