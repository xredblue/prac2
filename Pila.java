public class Pila{
    private int tope;
    private int tamanio;
    private String datos[];

    Pila(int tamanio){
        this.tope = 0;
        this.tamanio = tamanio;
        this.datos = new String[tamanio];
    }

    Pila(Pila pcopia){
        this.tope = pcopia.tope;
        this.tamanio = pcopia.tamanio;
        this.datos = pcopia.datos;
    }

    public void push(String x){
        try {
            this.datos[this.tope] = x;
            this.tope += 1;
        } catch (ArrayIndexOutOfBoundsException err){
            System.out.println("Se ha alcanzado el limite de espacio en la pila");
        }

    }

    public String pop(){
        try {
            this.tope -= 1;
            return this.datos[tope];
        } catch (ArrayIndexOutOfBoundsException err){
            System.out.println("La pila se encuentra vacia");
            this.tope = 0;
        }
        return "";
    }

    public boolean vacia(){
        return this.tope == 0;
    }

    public boolean llena(){
        return this.tope == this.tamanio;
    }

    public void mostrar(){
        for(int i = this.tope-1; i >= 0; i--) // extrae en el orden de la pila
            System.out.println(this.datos[i]);
    }

    public void suma(Pila a, Pila b){
        Pila aux_a;
        Pila aux_b;
        Pila suma;

        if (a.getTope() == b.getTope()){ // Las pilas tienen la misma cantidad de datos
            if (a.getTope() <= this.tamanio){ // La pila que almacena el resultado tiene espacios suficientes
                if (this.tope == 0){ // Garantiza que todos dos datos caben en la pila de resultados
                    aux_a = new Pila(a); // Copias de las pilas a sumar para no afectar a las pilas originales con "pop"
                    aux_b = new Pila(b);

                    suma = new Pila(a.getTamanio()); // pila que almacena la suma

                    for (int i = 0; i < a.getTope(); i++){
                        suma.push(aux_a.pop() + aux_b.pop()); // Sumando
                    }

                    for (int i = 0; i < a.getTope(); i++){
                        this.push(suma.pop()); // Colocando en el orden original
                    }
                } else {
                    System.out.println("La pila actual ya tiene datos almacenados, no puede almacenar las sumas");
                }
            } else {
                System.out.println("La pila actual no puede almacenar todas las sumas");
            }
        } else {
            System.out.println("Las pilas no tienen la misma cantidad de datos almacenados");
        }
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String[] getDatos() {
        return datos;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
}