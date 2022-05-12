package br.com.minhaloja.usuario;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioRepositoryJPA implements UsuarioRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("minhaloja-pu");
    private EntityManager em;

    public UsuarioRepositoryJPA() {
        em = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> findAll() {
        return em.createQuery("from Usuario").getResultList();  
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        em.getTransaction().commit();
        return usuario != null ? Optional.of(usuario) : Optional.empty() ;
    }

    @Override
    public Usuario save(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public Usuario update(Usuario usuario) {
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        em.remove(em.find(Usuario.class, id));
        em.getTransaction().commit();
    }
    
}
