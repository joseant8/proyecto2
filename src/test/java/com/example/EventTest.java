package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventTest {

    @Mock
    EventNotificationService eventNotificationService;

    @InjectMocks
    Event event;

    private Attendee attendee;
    private Speaker speaker;

    private List<Attendee> attendees;
    private List<Speaker> speakers;

    @BeforeEach
    public void init(){
        event = new Event(1L, "Mobile Week", EventType.TECH, eventNotificationService);
        attendee = new Attendee(1L, "Jose", "jose@email.com");
        speaker = new Speaker(1L, "Marta", "Nuevas tecnologías");

        attendees = new ArrayList<>();
        speakers = new ArrayList<>();
    }


    @Test
    void addAttendee() {
        assertFalse(event.getAttendees().contains(attendee));
        event.addAttendee(attendee);
        assertTrue(event.getAttendees().contains(attendee));
    }

    @Test
    void addAttendees() {
        assertFalse(event.getAttendees().contains(attendee));
        attendees.add(attendee);
        event.addAttendees(attendees);
        assertTrue(event.getAttendees().contains(attendee));
    }

    @Test
    void removeAttendee() {
        event.addAttendee(attendee);
        assertTrue(event.getAttendees().contains(attendee));
        event.removeAttendee(attendee);
        assertFalse(event.getAttendees().contains(attendee));
    }

    @Test
    void removeAttendees() {
        attendees.add(attendee);
        event.addAttendees(attendees);
        assertTrue(event.getAttendees().contains(attendee));
        event.removeAttendees(attendees);
        assertFalse(event.getAttendees().contains(attendee));
    }

    @Test
    void notifyAssistants() {
    }

    @Test
    void addSpeaker() {
    }

    @Test
    void removeSpeaker() {
    }

    @Test
    void getId() {
        assertNotNull(event.getId());
        assertEquals(Long.class, event.getId().getClass());
    }

    @Test
    void setId() {
        Long newId = 2L;
        assertNotEquals(event.getId(), newId);
        event.setId(newId);
        assertEquals(event.getId(), newId);
    }

    @Test
    void getTitle() {
        assertNotNull(event.getTitle());
        assertEquals(String.class, event.getTitle().getClass());
    }

    @Test
    void setTitle() {
        String newTitle = "Computer Week";
        assertNotEquals(newTitle, event.getTitle());
        event.setTitle(newTitle);
        assertEquals(newTitle, event.getTitle());
    }

    @Test
    void getType() {
        assertNotNull(event.getType());
        assertEquals(EventType.class, event.getType().getClass());
    }

    @Test
    void setType() {
        EventType newType = EventType.BUSINESS;
        assertNotEquals(newType, event.getType());
        event.setType(newType);
        assertEquals(newType, event.getType());
    }

    @Test
    void getSpeakers() {
        assertNotNull(event.getSpeakers());
    }

    @Test
    void setSpeakers() {
        Speaker newSpeaker = new Speaker(1L, "Juan", "Tecnología");
        speakers.add(newSpeaker);

        assertTrue(event.getSpeakers().isEmpty());
        event.setSpeakers(speakers);
        assertEquals(speakers, event.getSpeakers());
        assertSame(speakers, event.getSpeakers());
    }

    @Test
    void getAttendees() {
        assertNotNull(event.getAttendees());
    }

    @Test
    void setAttendees() {
        Attendee newAttendee = new Attendee(2L, "Antonio", "antonio@email.com");
        attendees.add(newAttendee);

        assertTrue(event.getAttendees().isEmpty());
        event.setAttendees(attendees);
        assertEquals(attendees, event.getAttendees());
        assertSame(attendees, event.getAttendees());
    }
}