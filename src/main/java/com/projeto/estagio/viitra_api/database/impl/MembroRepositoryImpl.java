package com.projeto.estagio.viitra_api.database.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.projeto.estagio.viitra_api.model.Membro;

@Component
public class MembroRepositoryImpl {

	@PersistenceContext
    private EntityManager entityManager;

    public List<Membro> buscarMembroPeloEmail(String email) {
        String hql = "FROM Membro WHERE email = :email";
    	TypedQuery<Membro> query = entityManager.createQuery(hql, Membro.class);
    	query.setParameter("email", email);
    	return query.getResultList();
    }
	
}
