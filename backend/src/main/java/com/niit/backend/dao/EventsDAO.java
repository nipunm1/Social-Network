package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Events;

public interface EventsDAO {
public boolean addEvents(Events events);
public boolean deleteEvents(Events events);
public boolean updateEvents(Events events);
public List<Events>getallEvents();
public Events getEventsById(int EventsId);
}
