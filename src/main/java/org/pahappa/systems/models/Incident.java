
package org.pahappa.systems.models;

import org.pahappa.systems.enums.*;

import javax.persistence.*;
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
@Entity
@Table(name = "incidents")
public class Incident {
    private int id;
    private String title;
    private Type  type;
    private Status status;
    private Date  createdOn;
    private String comment;
	private int counter;

	@Column(name = "counter")
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "type")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "status")
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "comment")
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
