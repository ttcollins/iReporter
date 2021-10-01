package org.pahappa.systems.services;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pahappa.systems.HibernateUtil;
import org.pahappa.systems.enums.Status;
import org.pahappa.systems.exceptions.ValidationFailedException;
import org.pahappa.systems.models.Incident;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService {
	private static Transaction transObj;
	private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();

	private static int incidentIds=0;

	@Override
	public void saveIncident(Incident incident) throws Exception {
		try {
			transObj = sessionObj.beginTransaction();
			sessionObj.save(incident);
			System.out.println("Record saved...");
		} catch (HibernateException exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}

	@Override
	public void updateIncident(Incident incident) throws Exception {
		try {
			transObj = sessionObj.beginTransaction();
			Incident editIn = (Incident) sessionObj.load(Incident.class, incident.getId());
			sessionObj.update(editIn);
			System.out.println("Record Updated");
		} catch ( HibernateException exceptionObj ) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
//		throw new SavingFailedException("Record not found");
	}

	@Override
	public List<Incident> getAllIncidents() {
		List<Incident> incidentsList = new ArrayList();
		try{
			transObj = sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("from Incident");

			incidentsList = queryObj.list();

		} catch ( HibernateException exceptionObj ) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
		return incidentsList;
	}

	@Override
	public List<Incident> getRedflagIncidents() {
		List<Incident> redflagIncidents = new ArrayList<>();
		try {
			transObj = sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("from Incident where type = 0");

			redflagIncidents = queryObj.list();


		} catch (HibernateException exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
		return redflagIncidents;
	}

	@Override
	public List<Incident> getInterventionIncidents() {
		List<Incident> interventionIncidents = new ArrayList<>();
		try {
			transObj = sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("from Incident where type = 1");

			interventionIncidents = queryObj.list();

		} catch (HibernateException exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
		return interventionIncidents;
	}

	@Override
	public int countIncidents() {
		List<Incident> incidents = new ArrayList<>();
		incidents = getAllIncidents();
		return incidents.size();
	}

	@Override
	public boolean incidentExists(Incident incident) {
		List<Incident> incidents = new ArrayList<>();
		incidents = getAllIncidents();

		String titleOfpassedIncident = incident.getTitle();
		for(Incident item:incidents){
			String titleOfIncident = item.getTitle();
			if(titleOfIncident == titleOfpassedIncident){
				if(item.getComment() == incident.getComment() && item.getType() == incident.getType()){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Incident getIncidentOfId(int id) {
		List<Incident> incidents = new ArrayList<>();

		try {
			transObj = sessionObj.beginTransaction();

			Query queryObj = sessionObj.createQuery("from Incident where id = id");

			incidents = queryObj.list();

			for(Incident item:incidents){
				return item;
			}

		} catch (HibernateException exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
		return null;
	}

	@Override
	public void deleteIncident(Incident incident) {
		if(incident != null){
			if(incidentExists(incident)){
				try {
					transObj = sessionObj.beginTransaction();
					sessionObj.delete(incident);
					System.out.println("Incident Record With Title: " + incident.getTitle() + " Is Successfully Deleted From Database");

				} catch (HibernateException exceptionObj) {
					exceptionObj.printStackTrace();
				} finally {
					transObj.commit();
				}
			}else{
				System.out.println("There is no record of this incident");
			}
		}else{
			System.out.println("Please an enter an incident to delete");
		}
	}

}
