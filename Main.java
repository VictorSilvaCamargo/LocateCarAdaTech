import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Aluguel.*;
import Atualizacao.*;
import Busca.*;
import Devolucao.*;
import Pessoa.*;
import Veiculo.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeiculoRepository veiculoRepository = new VeiculoRepository(); // Crie uma instância do VeiculoRepository

        PessoaFisicaRepository pessoaFisicaRepository = new PessoaFisicaRepository();
        PessoaJuridicaRepository pessoaJuridicaRepository = new PessoaJuridicaRepository();
        AluguelRepository aluguelRepository = new AluguelRepository();
        DevolucaoRepository devolucaoRepository = new DevolucaoRepository();

        AluguelManager aluguelManager = new AluguelManager(veiculoRepository, aluguelRepository);
        DevolucaoManager devolucaoManager = new DevolucaoManager(veiculoRepository, aluguelRepository, devolucaoRepository);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Cadastrar Pessoa Física");
            System.out.println("3. Cadastrar Pessoa Jurídica");
            System.out.println("4. Imprimir Lista de Veículos");
            System.out.println("5. Imprimir Lista de Pessoas Físicas");
            System.out.println("6. Imprimir Lista de Pessoas Jurídicas");
            System.out.println("7. Atualizar Cadastro");
            System.out.println("8. Alugar Veículo");
            System.out.println("9. Devolver Veículo");
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
                    scanner.nextLine();
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
                    System.out.println("Lista de Veículos Disponíveis:");
                    List<Veiculo> veiculosDisponiveis = veiculoRepository.obterVeiculosDisponiveis();

                    if (!veiculosDisponiveis.isEmpty()) {
                        for (Veiculo veiculo : veiculosDisponiveis) {
                            System.out.println("Nome: " + veiculo.getNome());
                            System.out.println("Placa: " + veiculo.getPlaca());
                            System.out.println("Tipo: " + veiculo.getTipo());
                            System.out.println("Disponível: " + (veiculo.isDisponivel() ? "Sim" : "Não"));
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nenhum veículo disponível no momento.");
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

                    scanner.nextLine();

                    if (opcaoAtualizacao == 1) {
                        System.out.println("Informe o CPF da pessoa física a ser atualizada:");
                        String cpfExistente = scanner.nextLine();

                        System.out.println("Informe o novo nome da pessoa física:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Informe o novo sobrenome da pessoa física:");
                        String novoSobrenome = scanner.nextLine();


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
                }
                case 8 -> {
                    System.out.println("Informe a placa do veículo a ser alugado:");
                    scanner.nextLine();
                    String placaAluguel = scanner.nextLine();

                    System.out.println("Informe o CPF ou CNPJ do cliente:");
                    String documentoCliente = scanner.nextLine();

                    LocalDateTime dataHoraInicio = LocalDateTime.now();
                    LocalDateTime dataHoraFim = dataHoraInicio.plusDays(1);

                    Pessoa cliente = null;

                    if (documentoCliente.length() == 11) {
                        cliente = pessoaFisicaRepository.encontarPessoaPorCPF(documentoCliente);
                    } else if (documentoCliente.length() == 14) {
                        cliente = pessoaJuridicaRepository.encontrarPessoaPorCNPJ(documentoCliente);
                    }

                    if (cliente != null) {
                        Aluguel aluguel = aluguelManager.alugarVeiculo(cliente, placaAluguel, dataHoraInicio, dataHoraFim);

                        if (aluguel != null) {
                            System.out.println("Veículo alugado com sucesso.");
                            System.out.println("Detalhes do aluguel:");
                            System.out.println("Cliente: " + cliente.getNome());
                            System.out.println("Veículo: " + aluguel.getVeiculo().getNome());
                            System.out.println("Data e Hora de Início: " + aluguel.getDataHoraInicio());
                            System.out.println("Data e Hora de Fim: " + aluguel.getDataHoraFim());
                        } else {
                            System.out.println("Erro ao alugar veículo.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 9 -> {
                    System.out.println("Informe a placa do veículo a ser devolvido:");
                    scanner.nextLine();
                    String placaDevolucao = scanner.nextLine();

                    System.out.println("Informe a data e hora de devolução (yyyy-MM-dd HH:mm:ss):");
                    String dataHoraDevolucaoStr = scanner.nextLine();

                    LocalDateTime dataHoraDevolucao = LocalDateTime.parse(dataHoraDevolucaoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    System.out.println("Informe o desconto (em porcentagem):");
                    double desconto = scanner.nextDouble();

                    Aluguel aluguel = aluguelRepository.encontrarAluguelPorPlaca(placaDevolucao);

                    if (aluguel != null) {
                        Devolucao devolucao = devolucaoManager.devolverVeiculo(aluguel, dataHoraDevolucao, desconto);

                        if (devolucao != null) {
                            System.out.println("Veículo devolvido com sucesso.");
                            System.out.println("Detalhes da devolução:");
                            System.out.println("Cliente: " + aluguel.getCliente().getNome());
                            System.out.println("Veículo: " + aluguel.getVeiculo().getNome());
                            System.out.println("Data e Hora de Devolução: " + devolucao.getDataHoraDevolucao());
                            System.out.println("Desconto Aplicado: " + devolucao.getDesconto() + "%");
                            System.out.println("Valor Total: R$ " + devolucao.getValorTotal());
                        } else {
                            System.out.println("Erro ao devolver veículo.");
                        }
                    } else {
                        System.out.println("Aluguel não encontrado para a placa informada.");
                    }
                }
                case 0 -> {
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}