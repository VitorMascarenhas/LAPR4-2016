package csheets.ext.agenda.domain;

import java.io.Serializable;

/**
 * Define the objects with Agenda.
 */
public interface ISchedulable extends Serializable
{
    Agenda agenda();
}
