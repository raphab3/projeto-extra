package com.databuilder.com.br.abcdata.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.abcdata.entity.Disciplina;
import com.databuilder.com.br.abcdata.entity.Estudante;
import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.entity.Servidor;
import com.databuilder.com.br.abcdata.entity.UnidadeEducacional;
import com.databuilder.com.br.abcdata.entity.enums.NivelDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.SituacaoEstudante;
import com.databuilder.com.br.abcdata.entity.enums.StatusLogin;
import com.databuilder.com.br.abcdata.entity.enums.TipoEtnia;
import com.databuilder.com.br.abcdata.entity.enums.TipoGenero;
import com.databuilder.com.br.abcdata.entity.enums.TipoServidor;
import com.databuilder.com.br.abcdata.repositories.DisciplinaRepository;
import com.databuilder.com.br.abcdata.repositories.EstudanteRepository;
import com.databuilder.com.br.abcdata.repositories.LoginRepository;
import com.databuilder.com.br.abcdata.repositories.ServidorRepository;
import com.databuilder.com.br.abcdata.repositories.UnidadeEducacionalRepository;

@Service
public class DBService {

	@Autowired
	private PasswordEncoder pe;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private UnidadeEducacionalRepository unidadeEducacionalRepository;

	@Autowired
	private ServidorRepository servidorRepository;


	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private EstudanteRepository estudanteRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	SimpleDateFormat sdfs = new SimpleDateFormat("dd/MM/yyyy");

	public void instantiateTestDatabase() throws ParseException {

		Login log1 = new Login(null, "diretor", "ADEROGILDO DA SILVA", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.DIRETOR_UN_EDUCACIONAL);
		Login log2 = new Login(null, "coordenador", "MARIA DA SILVA", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.COORDENADOR_UN_EDUCACIONAL);
		Login log3 = new Login(null, "teste@teste2.com.br", "JORGE NAILTON", pe.encode("1"), new Date(System.currentTimeMillis()), StatusLogin.BLOQUEADO, 0, NivelDeAcesso.PROFESSOR);
		Login log4 = new Login(null, "teste@teste3.com.br", "LEANDRO LIANDERSON", pe.encode("1"), new Date(), StatusLogin.INATIVO, 0, NivelDeAcesso.PROFESSOR);
		Login log5 = new Login(null, "admin", "WENDELL CLIVE SANTOS DE LIRA", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.ADMIN);
		Login log6 = new Login(null, "teste@teste4.com.br", "DECAMERON RODRIGUES ALVES", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.PROFESSOR);
		Login log7 = new Login(null, "teste@teste5.com.br", "CHARITAS HONORATO NUNES", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.PROFESSOR);
		Login log8 = new Login(null, "secretaria", "LUCICLELSON RAMIRES", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.SECRETARIA_UN_EDUCACIONAL);
		Login log9 = new Login(null, "professor", "MARIA APARECIDA XUXU", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.PROFESSOR);
		Login log10 = new Login(null, "gestorgeral", "NICACIO PERILO DA SILVA", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.GESTOR_GERAL);
		Login log11 = new Login(null, "gerentenucleo", "JOAO JOSE DA SILVAS", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.GERENTE_NUCLEO);
		Login log12 = new Login(null, "estudante", "CORINA SANTOS DA COSTA", pe.encode("1"), new Date(), StatusLogin.ATIVO, 0, NivelDeAcesso.ESTUDANTE);

		loginRepository
				.saveAll(Arrays.asList(log1, log2, log3, log4, log5, log6, log7, log8, log9, log10, log11, log12));

		Servidor ser1 = new Servidor(null, 2018001, log1.getNomeUsuario(),"01962636461", TipoGenero.MASCULINO, TipoEtnia.BRANCA, "BRASILEIRA", TipoServidor.ADMINISTRATIVO);
		Servidor ser2 = new Servidor(null, 2018002, log2.getNomeUsuario(),"12345678944", TipoGenero.FEMININO, TipoEtnia.BRANCA, "BRASILEIRA", TipoServidor.PEDAGOGICO);
		Servidor ser3 = new Servidor(null, 2018003, log3.getNomeUsuario(),"55544466677", TipoGenero.MASCULINO, TipoEtnia.NEGRA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser4 = new Servidor(null, 2018004, log4.getNomeUsuario(),"99988855532", TipoGenero.MASCULINO, TipoEtnia.PARDA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser5 = new Servidor(null, 2018005, log5.getNomeUsuario(),"32165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser6 = new Servidor(null, 2018006, log6.getNomeUsuario(),"42165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser7 = new Servidor(null, 2018007, log7.getNomeUsuario(),"52165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser8 = new Servidor(null, 2018008, log8.getNomeUsuario(),"62165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser9 = new Servidor(null, 2018009, log9.getNomeUsuario(),"72165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser10 = new Servidor(null, 2018010, log10.getNomeUsuario(),"82165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);
		Servidor ser11 = new Servidor(null, 2018011, log11.getNomeUsuario(),"92165498799", TipoGenero.MASCULINO, TipoEtnia.AMARELA, "BRASILEIRA", TipoServidor.PROFESSOR);

		UnidadeEducacional unedu1 = new UnidadeEducacional(null, "123456", "EMEF JOAO DORIA DA SILVA");
		UnidadeEducacional unedu2 = new UnidadeEducacional(null, "459877", "EMEM II ARGENTINA PEREIRA GOMES");
		UnidadeEducacional unedu3 = new UnidadeEducacional(null, "984654", "EMEF JOAO GOMES DE SA");
		UnidadeEducacional unedu4 = new UnidadeEducacional(null, "354791", "EMEF ARLINDA MARQUES");
		UnidadeEducacional unedu5 = new UnidadeEducacional(null, "194964", "EMEF TEOTONIO VILELA");
		UnidadeEducacional unedu6 = new UnidadeEducacional(null, "654749", "EMEF CRISTIAN LOBATO");
		UnidadeEducacional unedu7 = new UnidadeEducacional(null, "321478", "EMEF ORLANDO DO MONTE");
		UnidadeEducacional unedu8 = new UnidadeEducacional(null, "987412", "EMEM JOSE LINS DO REGO");

		servidorRepository.saveAll(Arrays.asList(ser1, ser2, ser3, ser4, ser5, ser6, ser7, ser8, ser9, ser10, ser11));

		unidadeEducacionalRepository
				.saveAll(Arrays.asList(unedu1, unedu2, unedu3, unedu4, unedu5, unedu6, unedu7, unedu8));

		Disciplina d1 = new Disciplina(null, "PORTUGUES", 60);
		Disciplina d2 = new Disciplina(null, "GEOGRAFIA", 40);
		Disciplina d3 = new Disciplina(null, "MATEMATICA", 60);
		Disciplina d4 = new Disciplina(null, "HISTORIA", 40);
		Disciplina d5 = new Disciplina(null, "CIENCIAS", 40);
		Disciplina d6 = new Disciplina(null, "FISICA", 40);
		Disciplina d7 = new Disciplina(null, "QUIMICA", 40);
		Disciplina d8 = new Disciplina(null, "FILOSOFIA", 40);
		Disciplina d9 = new Disciplina(null, "RELIGIAO", 40);
		Disciplina d10 = new Disciplina(null, "BIOLOGIA", 40);
		Disciplina d11 = new Disciplina(null, "GENETICA", 40);
		Disciplina d12 = new Disciplina(null, "INFORMATICA", 30);
		Disciplina d13 = new Disciplina(null, "ROBOTICA", 30);

		disciplinaRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13));

		Estudante estudante1= new Estudante(null, 2019000001, "ADRYANNE PORTILHO CARNEIRO MENDES", TipoGenero.FEMININO, TipoEtnia.BRANCA, "Brasileira", SituacaoEstudante.ATIVO);	
		Estudante estudante2= new Estudante(null, 2019000002, "ALESSANDRA MENDES MONTEIRO", TipoGenero.FEMININO, TipoEtnia.BRANCA, "Brasileira",  SituacaoEstudante.ATIVO);
		Estudante estudante3= new Estudante(null, 2019000003, "ALEX ALVES BARBOSA", TipoGenero.MASCULINO, TipoEtnia.NEGRA, "Brasileira", SituacaoEstudante.ATIVO);
		Estudante estudante4= new Estudante(null, 2019000004, "ALINE LIMA CAMPELO", TipoGenero.FEMININO, TipoEtnia.BRANCA, "Brasileira", SituacaoEstudante.ATIVO);
		Estudante estudante6= new Estudante(null, 2019000006, "ANDRÉ LUIS GONZALES AMORIS", TipoGenero.MASCULINO, TipoEtnia.BRANCA, "Brasileira", SituacaoEstudante.ATIVO);
		Estudante estudante5= new Estudante(null, 2019000005, "ÁLISTER ALVES MOREIRA", TipoGenero.MASCULINO, TipoEtnia.NEGRA, "Brasileira", SituacaoEstudante.ATIVO);
		Estudante estudante7= new Estudante(null, 2019000007, "ANTONIO MANOEL DA SILVEIRA JUNIOR", TipoGenero.MASCULINO, TipoEtnia.NEGRA, "Brasileira", SituacaoEstudante.ATIVO);
		Estudante estudante8= new Estudante(null, 2019000008, "AQUILES DE ALMEIDA JUNIOR", TipoGenero.MASCULINO, TipoEtnia.PARDA, "Brasileira", SituacaoEstudante.ATIVO);
		
		estudanteRepository.saveAll(Arrays.asList(estudante1,	estudante2,	estudante3,	estudante4,	estudante5,	estudante6,	estudante7,	estudante8));
		
	}
}
