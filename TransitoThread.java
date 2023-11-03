
import java.util.ArrayList;
import java.util.Random;


public class TransitoThread extends Thread{
    private SemaforoThread semaforo;
    private Integer acumulacion;
    private ArrayList<Auto> autos;
    
    public TransitoThread(SemaforoThread semaforo) {
        this.semaforo = semaforo;
        this.acumulacion = 0;
        autos = new ArrayList<>();    
    }
    
    public void run() {
        try {
            while (true) {
                if (semaforo.getEstado().equals("verde")) {
                    this.removerAuto();
                    //System.out.print("\t\t\tAutos despachados en verde: " );
                    Thread.sleep(2000); // 2 segundos
                    

                } else if (semaforo.getEstado().equals("amarillo")) {
                    this.removerAuto();
                    Thread.sleep(1000); // 1 segundo

                } else {
                    this.acumulacion = new Random().nextInt(8) + 1;
                     System.out.println("\t\t\tAutos nuevos en el semaforo: " + acumulacion);
                    for (int i = 0; i < acumulacion; i++) {
                        autos.add(new Auto());
                    }
                    //Bloque de formato de impresión
                    imprimirAutosEnSemaforo();

                    Thread.sleep(5000); 
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getAcumulacion() {
        return acumulacion;
    }
    public ArrayList<Auto> getAutos() {
        return autos;
    }

   public void removerAuto() {
    if (!autos.isEmpty()) {
        Auto autoRemovido = autos.remove(0);
        System.out.print("#" + autoRemovido.getId() + " "); // Acumula los IDs en una línea
        System.out.println();
    }
}

    public void imprimirAutosEnSemaforo() {
        System.out.println("\t\t\tTotal de autos en semaforo: " + autos.size());
        System.out.println("\t\t\tAutos en el semáforo: ");
        System.out.print("\t\t\t");
        for (Auto auto : autos) {
            System.out.print("#" + auto.getId() + " ");
        }
        System.out.print("\n");
    }
}
