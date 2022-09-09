public class Cola {
    private int entrada;
    private int salida;
    private int tamanio;
    private String datos[];

    Cola(int tamanio){
        this.entrada = 0;
        this.salida = 0;
        this.tamanio = tamanio;
        this.datos = new String[tamanio];
    }

    public void insertar(String x){
        this.datos[this.entrada] = x;
        this.entrada += 1;
    }

    public String extraer(){
        String x = this.datos[this.salida];
        this.salida += 1;
        return x;
    }

    public void mostrar(){
        for (int i = 0; i < this.datos.length; i++){
            System.out.print(this.datos[i] + " ");
        }
        System.out.println();
    }

    public boolean vacia(){
        return this.entrada == this.salida;
    }

    public boolean llena(){
        return this.entrada == this.tamanio;
    }

    public int getTamanio(){
        return this.tamanio;
    }
    
    public String[] getDatos(){
        return this.datos;
    }

}
