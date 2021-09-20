
package org.pahappa.systems.models;

import org.pahappa.systems.enums.*;

import java.util.Date;

/**
 * The class {@code Incident} represents an occurrence, condition, 
 * or situation arising in the course of work that resulted in or could 
 * have resulted in injuries, illnesses, damage, or fatalities.
 * 
 * {@code Incident} should have an id, title, type[Redflag, Intervention], 
 * status[Draft, Under investigation, Resolved, Rejected], createdOn and comment
 *
 */
public class Incident {
    private int id;
    private String title;
    private Type  type;
    private Status status;
    private Date  createdOn;
    private String comment;
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return title;
	}
}
