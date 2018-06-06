package csheets.ext.agenda.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * Defines Event contract.
 */
public interface IEvent extends Serializable
{
    boolean isValid();
    boolean updateDescription(String description);
    boolean updateDueDate(Date dueDate);
    Date dueDate();
    String description();

}
