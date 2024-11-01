package ejemplostack;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author MSI
 */
public class StackApp {

    static Grua myCrane;

    public static void main(String[] args) throws Exception {

        myCrane = new Grua();
        int opcion = 1;
        while (opcion != 0) {
            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog("MENU\n"
                            + "0.- Salir \n"
                            + "1.- Agregar caja \n"
                            + "2.- Mostrar pila de cajas \n"
                            + "3.- Vaciar contenedor \n"
                            + "4.- About me ̿̿ ̿̿ ̿̿ ̿'̿'\\̵͇̿̿\\з= ( ▀ ͜͞ʖ▀) =ε/̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿ \n"));

            switch (opcion) {
                case 1: {
                    try {
                        add();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    break;
                }
                case 2: {
                    Font defaultFont = UIManager.getDefaults().getFont("OptionPane.messageFont");
                    UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.BOLD, 14));
                    myCrane.mostrarTodo();
                    UIManager.put("OptionPane.messageFont", defaultFont);
                    break;
                }
                case 3:
                    boolean success = myCrane.vaciar();
                    if (success) {
                        JOptionPane.showMessageDialog(null, "LISTO!! - Contenedor vaciado");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR - No hay cajas en el contenedor ¯\\_(ツ)_/¯");
                    }
                    break;

                case 4:
                    Font defaultFont = UIManager.getDefaults().getFont("OptionPane.messageFont");
                    UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.BOLD, 14));

                    JOptionPane.showMessageDialog(null, "\n"
                            + "#>  --------------------------------------------------------\n"
                            + "#>    Marco Antonio Gutiérrez Reyes \n"
                            + "#>  --------------------------------------------------------\n"
                            + "#>     \\\n"
                            + "#>       \\\n"
                            + "#>         \\\n"
                            + "#>             |\\___/|\n"
                            + "#>           ==) ^Y^ (==\n"
                            + "#>             \\  ^  /\n"
                            + "#>              )=*=(\n"
                            + "#>             /     \\\n"
                            + "#>             |     |\n"
                            + "#>            /| | | |\\\n"
                            + "#>            \\| | |_|/\\\n"
                            + "#>            //_// ___/\n"
                            + "#>                \\_)\n"
                            + "#> ");
                    UIManager.put("OptionPane.messageFont", defaultFont);
            }

        }
    }

    public static void add() throws Exception {
        String tipo = JOptionPane.showInputDialog(null, "Selecciona el material de la caja que deseas agregar\n"
                + " 1).- METAL\n "
                + "2).- MADERA\n "
                + "3).- PLASTICO");

        switch (tipo) {
            case "1": {
                tipo = "METAL";

                break;
            }
            case "2": {
                tipo = "MADERA";

                break;
            }
            case "3": {
                tipo = "PLASTICO";

                break;
            }
        }

        if (!tipo.equals("METAL") && !tipo.equals("MADERA") && !tipo.equals("PLASTICO")) {
            JOptionPane.showMessageDialog(null, "¡¡INVALIDO!! - Seleciona una de las opciones disponibles");
            return;
        }
        Caja box = new Caja(tipo);
        myCrane.add(box);
        JOptionPane.showMessageDialog(null, "Caja agregada");

    }
}
