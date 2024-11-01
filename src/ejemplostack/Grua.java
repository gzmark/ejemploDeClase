package ejemplostack;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Grua {

    Stack<Caja> stack = new Stack<>();

    public int calculateWeight() {

        Stack<Caja> temporal = new Stack<>();
        int total = 0;

        while (!stack.isEmpty()) {
            Caja extract = stack.pop();
            temporal.push(extract);
            total += extract.peso();

        }
        while (!temporal.isEmpty()) {
            stack.push(temporal.pop());
        }

        return total;
    }

    public int espacioDisponible() {
        int disponible = 5000 - calculateWeight();
        return disponible;
    }

    public void add(Caja box) throws Exception {
        Stack<Caja> temp = new Stack<>();

        if (calculateWeight() + box.peso() > 5000) {
            Exception errorObj = new Exception("¡¡Peso excedido!! " + "Limite Disponible: " + espacioDisponible());
            throw errorObj;
        }

        if (stack.isEmpty()) {
            stack.push(box);
            return;
        }
        while (!stack.isEmpty()) {
            Caja top = stack.peek();
            if (box.peso() == top.peso()) {
                break;
            } else if (box.peso() > top.peso()) {
                temp.push(stack.pop());
            } else if (box.peso() < top.peso()) {
                break;
            }

        }
        stack.push(box);
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
    }

    public void mostrarTodo() {

        Stack<Caja> temporal = new Stack<>();

        if (stack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contenedor vacio");
            return;
        }

        String fullString = "";

        while (!stack.isEmpty()) {
            Caja extract = stack.pop();
            temporal.push(extract);

            fullString += extract.toString();
        }
        while (!temporal.isEmpty()) {
            stack.push(temporal.pop());
        }

        JOptionPane.showMessageDialog(null, fullString);

    }

    boolean vaciar() {

        if (stack.isEmpty()) {
            return false;
        } else {
            stack.clear();
            return true;
        }
    }

}
