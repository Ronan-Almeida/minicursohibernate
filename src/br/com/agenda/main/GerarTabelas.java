package br.com.agenda.main;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelas {

	public static void main(String[] args) {
		
		/*
		 * OBS: Os detalhes dos campos nas tabelas
		 * como tamanho, restrinções, valores default
		 * não serão definidos pois para isso teriamos
		 * que colocar todas as anatações referentes a esses detalhes
		 * no mapeamendo das entidades
		 * 
		 * -> Prefira criar o banco manualmente, pois assim vc não precisa
		 * -> poluir as classes de entidades com muitas anotações.
		 */
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);

	}

}
