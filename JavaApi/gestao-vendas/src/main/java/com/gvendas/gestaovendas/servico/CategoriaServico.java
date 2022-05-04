package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public List<Categoria> listarTodas() {
		LOGGER.info("Transacao=listarTodas");
		return categoriaRepositorio.findAll();
	}

	public Optional<Categoria> buscarPorCodigo(Long codigo) {
		LOGGER.info("Transacao=buscarPorCodigo");
		return categoriaRepositorio.findById(codigo);
	}

	public Categoria salvar(Categoria categoria) {
		validarCategoriaDuplicada(categoria);
		LOGGER.info("Transacao=salvar");
		return categoriaRepositorio.save(categoria);
	}

	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalvar = validarCategoriaExiste(codigo);
		validarCategoriaDuplicada(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalvar, "cadigo");
		LOGGER.info("Transacao=atualizar");
		return categoriaRepositorio.save(categoriaSalvar);
	}

	public void deletar(Long codigo) {
		categoriaRepositorio.deleteById(codigo);
		LOGGER.info("Transacao=deletar");
	}

	private Categoria validarCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarPorCodigo(codigo);
		if (categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();

	}

	private void validarCategoriaDuplicada(Categoria categoria) {
		Categoria categoriaEncontrada = categoriaRepositorio.findByNome(categoria.getNome());
		if (categoriaEncontrada != null && categoriaEncontrada.getCodigo() != categoria.getCodigo()) {
			LOGGER.warn("Erro foi=Duplicate");
			throw new RegraNegocioException(
					String.format("A categoria %s já está cadastrada", categoria.getNome().toUpperCase()));
		}
	}

}
