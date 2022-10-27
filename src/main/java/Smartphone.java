public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, int cost, String name, String producer) {
        super(id, cost, name);
        this.producer = producer;
    }
}
