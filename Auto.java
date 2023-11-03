public class Auto {
    private static int contador = 1;
    private int id;

    public Auto(){
        this.id = contador++;
    }

    public int getId() {
        return id;
    }
}
