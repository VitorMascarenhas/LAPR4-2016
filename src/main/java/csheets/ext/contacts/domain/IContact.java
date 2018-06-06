package csheets.ext.contacts.domain;

import csheets.persistence.AggregateRoot;

import java.io.Serializable;

/**
 * A Abstract class that implements persist system.
 * In this way we can use persist methods in all types of contacts.
 * @author Pedro Costa.
 */
public interface IContact extends Serializable
{
    boolean isValid();

    boolean update(IContact contact);

    Long id();
}
