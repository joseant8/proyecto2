package com.example.service;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventNotificationTest {

    private Event event;
    private Attendee attendee;
    private EventNotificationService eventNotification;

    @BeforeEach
    public void init(){
        event = new Event(1L, "Mobile Week", EventType.TECH, null);
        attendee = new Attendee(1L, "Jose", "jose@email.com");
        eventNotification = new EventNotificationServiceImpl();
    }



    @Test
    void announce() {
        assertNotNull(eventNotification);

        // Si el asistente no está en la lista del evento, no tendrá la notificación
        eventNotification.announce(event);
        assertTrue(attendee.getNotifications().isEmpty());

        // Si el asistente está en la lista del evento, tendrá la notificación
        event.addAttendee(attendee);
        eventNotification.announce(event);
        assertFalse(attendee.getNotifications().isEmpty());
    }

    @Test
    void confirmAttendance() {
        assertNotNull(eventNotification);

        // Si el evento es nulo, el asistente no tendrá la notificación de confirmación
        eventNotification.confirmAttendance(null, attendee);
        assertTrue(attendee.getNotifications().isEmpty());

        // Si existe el evento, el asistente tendrá la notificación de confirmación
        eventNotification.confirmAttendance(event, attendee);
        assertFalse(attendee.getNotifications().isEmpty());
    }
}