package csheets.persistence;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Paulo Gandra Sousa
 */
public interface DeleteableRepository<T, K> extends IRepository<T, K> {

    /**
     * removes the specified entity from the repository.
     *
     * @param entity
     * sense for this repository
     */
    void delete(T entity);

    /**
     * Removes the entity with the specified ID from the repository.
     *
     * sense for this repository
     */
    void deleteById(K entityId);
}
