public class Polaca {
    private Cola colaEntrada;
    private Pila pilaOperadores;
    private Cola colaSalida;

    Polaca(Cola colaEntrada){
        this.ColaEntrada(colaEntrada);
        this.Postfija();
        this.evaluacion();
    }

    public void ColaEntrada(Cola colaEntrada){
        int totalElementos = colaEntrada.getTamanio();
        this.colaEntrada = new Cola(totalElementos);
        this.colaSalida = new Cola(totalElementos);
        this.pilaOperadores = new Pila(totalElementos);
        
        for (int i = 0; i<totalElementos; i++){
            this.colaEntrada.insertar(colaEntrada.extraer());
        }
    }
    
    public void Postfija(){

        String extraidoCEntrada = "";
        String extraidoPilaOp = "";
        int aux = 0;
        boolean igualPrioridad = true;
        boolean mayorPrioridad = true;
        String p1 = "/*"; // Operadores Prioridad 1
        String p2 = "+-"; // Operadores Prioridad 2

        while (!this.colaEntrada.vacia()){
            try { // Si es numero, a la cola de salida
                extraidoCEntrada = this.colaEntrada.extraer();
                aux = Integer.parseInt(extraidoCEntrada); // es numero?
                this.colaSalida.insertar(""+aux);
            } catch (NumberFormatException err){ // Si es operador

                if (pilaOperadores.vacia()){
                    pilaOperadores.push(extraidoCEntrada);
                } else {

                    // Se rompe este while si:
                    // - la prioridad no es igual o mayor
                    // - la pila pOperadores está vacía
                    while (!pilaOperadores.vacia()) {

                        // Se extraen operadores de
                        // pOperadores para hacer comparaciones
                        // con extraidoCEntrada
                        extraidoPilaOp = pilaOperadores.pop();
                        igualPrioridad = ((p1.contains(extraidoCEntrada) && p1.contains(extraidoPilaOp)) || (p2.contains(extraidoCEntrada) && p2.contains(extraidoPilaOp)));
                        mayorPrioridad = (p1.contains(extraidoPilaOp) && p2.contains(extraidoCEntrada));

                        if (igualPrioridad || mayorPrioridad) { // igual o mayor prioridad
                            colaSalida.insertar(extraidoPilaOp);
                        } else {

                            // regresa el extraidoPilaOp y push extraidoCEntrada
                            pilaOperadores.push(extraidoPilaOp);
                            pilaOperadores.push(extraidoCEntrada);
                            break;
                        }
                    }

                    // Se comprueba si la pila se vació
                    // para no agregar extraidoCEntrada
                    // dos veces.
                    if (pilaOperadores.vacia()){
                        pilaOperadores.push(extraidoCEntrada);
                    }
                }
            }
        }

        // ingresa a cSalida los operadores sobrantes de la pOperadores
        while (!pilaOperadores.vacia()){
            this.colaSalida.insertar(pilaOperadores.pop());
        }

        getColaSalida().mostrar();
    }

    public void evaluacion(){

        String extraidoCSalida = "";
        float aux = 0;
        float a = 0;
        float b = 0;

        while (!colaSalida.vacia()){
            try {
                extraidoCSalida = colaSalida.extraer();
                aux = Integer.parseInt(extraidoCSalida); // es numero?
                this.pilaOperadores.push(""+aux);
            } catch (NumberFormatException err){

                // extrae 2 numeros y los suma
                b = Float.parseFloat(pilaOperadores.pop());
                a = Float.parseFloat(pilaOperadores.pop());

                switch (extraidoCSalida){
                    case "+":
                        pilaOperadores.push(Float.toString(a+b));
                        break;
                    case "-":
                        pilaOperadores.push(Float.toString(a-b));
                        break;
                    case "*":
                        pilaOperadores.push(Float.toString(a*b));
                        break;
                    case "/":
                        pilaOperadores.push(Float.toString(a/b));
                        break;
                    default:
                }
            }
        }

        // Respuesta
        float num = Float.parseFloat(pilaOperadores.pop());
        System.out.println(num);
    }

    public Cola getColaEntrada(){
        return this.colaEntrada;
    }

    public Cola getColaSalida(){
        return this.colaSalida;
    }
}
