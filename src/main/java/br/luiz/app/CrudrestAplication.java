package br.luiz.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.luiz.service.CrudrestService;

public class CrudrestAplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public CrudrestAplication() {
		singletons.add(new CrudrestService());
	}

	public Set<Object> getSingletons() {
		return singletons;
	}
}
