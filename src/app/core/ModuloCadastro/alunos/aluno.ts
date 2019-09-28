export class Aluno {

    // Dados Pessoais
    id: number;
    nome: string;
    dataNascimento: string;
    genero: string;
    etinia: string;
    paisDeOrigem: string;
    estadoDeOrigem: string;
    municipioDeOrigem: string;
    filiacao: string;
    filiacaoMae: string;
    filiacaoPai: string;
    dataCadastro: Date;
    dataUltimaAlteracao: Date;

    // Dados Escolares
    nomeEnsino: string;
    nomeSerie: string;
    nomeTurma: string;
    nomeTurno: string;
    codigo: string;
    cpf: string;
    nomeResponsavel: string;
    emailResponsavel: string;
    telefoneResponsavel: string;

    // Endereco
    cep: string;
    logradouro: string;
    complemento: string;
    bairro: string;
    cidade: string;
    uf: string;
    numero: string;
    distrito: string;
    zonaResidencial: string;

     // contatdo
     telefone: string;
     email: string;
}
