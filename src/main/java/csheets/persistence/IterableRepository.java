package csheets.persistence;

import java.util.Iterator;

/**
 * A IRepository which can be efficiently iterated.
 *
 * the implementation class must provide for an efficient iterator over all
 * entities in the repository. this is particular the case for database-backed
 * up persistence stores where one expects a cursor like behaviour. it is the
 * responsibility of the implementation class to handle disconnected scenarios
 * or not.
 *
 * @author Paulo Gandra Sousa
 */
public interface IterableRepository<T, K> extends IRepository<T, K>, Iterable<T> {

    Iterator<T> iterator(int pagesize);
}
