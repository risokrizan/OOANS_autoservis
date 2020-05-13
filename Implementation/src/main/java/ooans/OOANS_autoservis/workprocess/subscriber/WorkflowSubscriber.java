package ooans.OOANS_autoservis.workprocess.subscriber;

public class WorkflowSubscriber implements ServiceStateSubcriber{

    @Override
    public void update() {
        System.out.println("Notifikujem internu tabulu priradenia prace.");
    }
}
