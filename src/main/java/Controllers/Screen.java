package Controllers;

import Models.*;

import java.awt.*;


public class Screen {
    private static Client currentClient;
    private static Employee currentEmployee;
    private static LawSuit currentLawsuit;
    private static Event currentEvent;
    private static DocumentTemplates currentdocumentTemplates;
    private static Meeting currentMeeting;
    private static boolean isEdition = false;

    public boolean getIsEdition() {
        return isEdition;
    }

    public void setIsEdition(boolean isEdition) {
        Screen.isEdition = isEdition;
    }


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

    public static DocumentTemplates getCurrentdocumentTemplates() {
        return currentdocumentTemplates;
    }

    public static void setCurrentdocumentTemplates(DocumentTemplates currentdocumentTemplates) {
        Screen.currentdocumentTemplates = currentdocumentTemplates;
    }
}
