public class Main {
    public static void main(String[] args) {
        Cola colaEntrada = new Cola(9);
        colaEntrada.insertar("17");
        colaEntrada.insertar("-");
        colaEntrada.insertar("34");
        colaEntrada.insertar("/");
        colaEntrada.insertar("2");
        colaEntrada.insertar("40");
        colaEntrada.insertar("*");
        colaEntrada.insertar("200");
        colaEntrada.insertar("3");
        System.out.println("Forma postfija");
        Polaca a = new Polaca(colaEntrada);
    }
}