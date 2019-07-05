package com.niit.backend.model;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "S_Events")
@Component
public class Events {
@Id
@GeneratedValue
int EventsId;
private String EventsName;
private String EventsVenue;
private Clob EventsDescription;
private String EventsDate;
private Blob EventsImage;
public int getEventsId() {
	return EventsId;
}
public void setEventsId(int eventsId) {
	EventsId = eventsId;
}
public String getEventsName() {
	return EventsName;
}
public void setEventsName(String eventsName) {
	EventsName = eventsName;
}
public String getEventsVenue() {
	return EventsVenue;
}
public void setEventsVenue(String eventsVenue) {
	EventsVenue = eventsVenue;
}
public Clob getEventsDescription() {
	return EventsDescription;
}
public void setEventsDescription(Clob eventsDescription) {
	EventsDescription = eventsDescription;
}
public String getEventsDate() {
	return EventsDate;
}
public void setEventsDate(String eventsDate) {
	EventsDate = eventsDate;
}
public Blob getEventsImage() {
	return EventsImage;
}
public void setEventsImage(Blob eventsImage) {
	EventsImage = eventsImage;
}
}
