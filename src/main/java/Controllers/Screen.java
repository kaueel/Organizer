package Controllers;

import Models.Client;
import Models.Employee;
import Models.LawSuit;
import Models.Meeting;

import java.awt.*;


public class Screen {
    private static Client currentClient;
    private static Employee currentEmployee;
    private static LawSuit currentLawsuit;
    private static Event currentEvent;
    private static Meeting currentMeeting;

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public Meeting getCurrentMeeting() {
        return currentMeeting;
    }

    public void setCurrentMeeting(Meeting currentMeeting) {
        this.currentMeeting = currentMeeting;
    }


    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    public Employee getCurrentEmplyee() {
        return currentEmployee;
    }

    public void setCurrentEmplyee(Employee currentEmplyee) {
        this.currentEmployee = currentEmplyee;
    }

    public LawSuit getCurrentLawsuit() {
        return currentLawsuit;
    }

    public void setCurrentLawsuit(LawSuit currentLawsuit) {
        this.currentLawsuit = currentLawsuit;
    }

    public Event getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }


}
