package Exercise4;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Sheldon");
        Human human2 = new Human("Leonard");
        Human human3 = new Human("Volovist");
        Human human4 = new Human("Kytrapalli");
        Human human5 = new Human("Penni");

        QueueForCola queueForCola = new QueueForCola();
        queueForCola.addHuman(human1);
        queueForCola.addHuman(human2);
        queueForCola.addHuman(human3);
        queueForCola.addHuman(human4);
        queueForCola.addHuman(human5);

        queueForCola.getQueueState(2);
    }
}
