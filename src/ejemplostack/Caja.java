package ejemplostack;

public class Caja {

    private String tipo;

    public Caja(String tipo) {
        this.tipo = tipo;
    }

    public int peso() {
        if (this.tipo.equals("PLASTICO")) {
            return 250;
        } else if (this.tipo.equals("MADERA")) {
            return 500;
        } else if (this.tipo.equals("METAL")) {
            return 1000;
        }
        return 0;
    }

    @Override
    public String toString() {
         String res = String.format(
                "----------------------------\n" +
                "|   Tipo: %-15.15s  |\n" +
                "----------------------------\n", tipo);

        return res;
    }

}
