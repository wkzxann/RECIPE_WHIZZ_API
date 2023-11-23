package com.cibertec.edu.services;

import java.util.List;

import com.cibertec.edu.entity.Receta;

public interface RecetaService {
	
	public List<Receta> listarTodos();
	public List<Receta> listarFavoritosPorUsuario(Integer cod);
	public Receta registrar(Receta receta);
	public Receta actualizar(Receta receta);
	public void eliminar(Integer cod);
	public Receta BuscarPorId(Integer cod);

}
