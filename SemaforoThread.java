
public class SemaforoThread extends Thread{

    private String estado;

    public SemaforoThread() {
        this.estado = "rojo";

    }
    public void run() {
        try {
            while (true) {
                //Semaforo en Verde
                if (estado.equals("verde")) {
                    System.out.println("Semaforo: Verde");
                    Thread.sleep(8000); // 8 segundos
                    estado = "amarillo";
                
                //Semaforo en amarillo
                } else if (estado.equals("amarillo")) {
                    System.out.println("Semaforo: Amarillo");
                    Thread.sleep(2000); // 2 segundos
                    estado = "rojo";
                
                //Semaforo rojo
                } else {
                    System.out.println("Semaforo: Rojo");

                    Thread.sleep(5000); // 10 segundos
                    estado = "verde";
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public String getEstado() {
        return estado;
    }

}
