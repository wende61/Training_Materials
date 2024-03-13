package org.eclipse.jakarta.hello.repository;

import java.util.List;

import org.eclipse.jakarta.hello.model.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named
@ApplicationScoped
public class UserRepository {
    
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Transactional
    public User save(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT e FROM users e", User.class).getResultList();
    }
}
