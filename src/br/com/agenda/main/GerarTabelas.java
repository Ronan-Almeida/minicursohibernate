package br.com.agenda.main;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelas {

	public static void main(String[] args) {
		
		/*
		 * OBS: Os detalhes dos campos nas tabelas
		 * como tamanho, restrin��es, valores default
		 * n�o ser�o definidos pois para isso teriamos
		 * que colocar todas as anata��es referentes a esses detalhes
		 * no mapeamendo das entidades
		 * 
		 * -> Prefira criar o banco manualmente, pois assim vc n�o precisa
		 * -> poluir as classes de entidades com muitas anota��es.
		 */
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);

	}

}
