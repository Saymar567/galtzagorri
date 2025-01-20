package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value="SELECT * FROM usuarios "
			+ "where usuario = :user and pass= :pass", nativeQuery = true)
	Usuario validarUsuario(@Param("user") String usu, @Param("pass") String pass);

}
