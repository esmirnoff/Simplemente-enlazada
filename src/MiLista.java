import java.util.Iterator;

public class MiLista implements ListInterface{
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null){
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;

    }

    @Override
    public Object getHead() {
        if (cabeza == null){
            return null;
        }else {
            return cabeza.dato;
        }
    }

    @Override
    public Object getTail() {
        if (cabeza == null){
            return null;
        }else{
            ListNode iterador = cabeza;
            while (iterador.siguiente != null){
                iterador = iterador.siguiente;
            }
            return iterador.dato;
        }
    }

    @Override
    public Object get(ListNode node) {
        if (node == null){
            return null;
        }else{
            return node.dato;
        }
    }

    @Override
    public Object search(Object object) {
        ListNode iterador = cabeza;
        while (iterador.siguiente != null){
            if (iterador.dato.equals(object)){
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        ListNode nuevo = new ListNode(object);
        if (cabeza == null){
            cabeza = nuevo;
        }else{
            ListNode iterador = cabeza;
            while (iterador.siguiente!=null){
               iterador = iterador.siguiente;
            }
            iterador.siguiente = nuevo;
        }
        return true;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        if (node == null){
            return false;
        }else{
            ListNode nuevo = new ListNode(object);
            nuevo.siguiente = node.siguiente;
            node.siguiente = nuevo;
            return true;
        }
    }

    @Override
    public boolean insert(Object ob, Object object) {
        ListNode iterador = cabeza;
        while (iterador != null){
            if (iterador.dato.equals(ob)){
                ListNode nuevo = new ListNode(object);
                nuevo.siguiente = iterador.siguiente;
                iterador.siguiente = nuevo;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e){
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if(this.cabeza == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        }else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        return null;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
