package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventTest {

    @Mock
    EventNotificationService eventNotificationService;

    @InjectMocks
    Event event;

    private Attendee attendee;

    @BeforeEach
    public void init(){
        event = new Event(1L, "Mobile Week", EventType.TECH, eventNotificationService);
        attendee = new Attendee(1L, "Jose", "jose@email.com");
    }


    @Test
    void addAttendee() {


    }

    @Test
    void addAttendees() {
    }

    @Test
    void removeAttendee() {
    }

    @Test
    void removeAttendees() {
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
    }

    @Test
    void getSpeakers() {
    }

    @Test
    void setSpeakers() {
    }

    @Test
    void getAttendees() {
    }

    @Test
    void setAttendees() {
    }
}