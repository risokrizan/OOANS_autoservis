package ooans.OOANS_autoservis.workprocess.subscriber;

public class NotificationSubscriber implements ServiceStateSubcriber {
    @Override
    public void update() {
        System.out.println("Posielam push notifikaciu do zakaznickej app.");
    }
}
