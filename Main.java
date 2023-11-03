//package Ejercicios;

public class Main {
    public static void main(String[] args) {
        SemaforoThread semaforo = new SemaforoThread();
        TransitoThread transito = new TransitoThread(semaforo);
        
        semaforo.start();
        transito.start();
    }
}
