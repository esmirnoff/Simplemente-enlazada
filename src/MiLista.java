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
        if (node == null){
            return false;
        }else{
            node.dato = object;
            return true;
        }
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null || cabeza == null) {
            return false;
        } else if (node == cabeza) {
            cabeza = cabeza.siguiente;
            return true;
    }else {
            ListNode iterador = cabeza;
            while (iterador.siguiente != null){
                if (iterador.siguiente == node){
                    iterador.siguiente = iterador.siguiente.siguiente;
                    return true;
                }
                iterador = iterador.siguiente;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        ListNode iterador = cabeza;
        while (iterador.siguiente != null){
            if (iterador.dato.equals(object)){
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return new Iterator<ListNode>() {
            private ListNode actual = cabeza;
            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public ListNode next() {
                ListNode Temp = actual;
                actual = actual.siguiente;
                return Temp;
            }
        };
    }

    @Override
    public Object[] toArray() {
        int contador = 0;
        ListNode iterador = cabeza;
        while (iterador.siguiente != null){
            contador++;
            iterador = iterador.siguiente;
        }
        Object[] array = new Object[contador];
        iterador = cabeza;
        int i = 0;
        while (iterador.siguiente != null){
            array[i++] = iterador.dato;
            iterador = iterador.siguiente;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int i = 0;
        ListNode iterador = cabeza;
        while (iterador != null){
            if(i<object.length){
                object[i] = iterador.dato;
            }
            iterador = iterador.siguiente;
            i++;
        }
        if (i>object.length){
            Object[] nuevo = new Object[i];
            iterador = cabeza;
            int j = 0;
            while (iterador != null){
                nuevo[j++] = iterador.dato;
                iterador = iterador.siguiente;
            }
            return nuevo;
        }
        return object;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        if (node == null || cabeza == null || node == cabeza){
            return null;
        }
        ListNode iterador = cabeza;
        while (iterador.siguiente != null){
            if (iterador.siguiente == node){
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        if(node == null || node.siguiente == null){
            return null;
        }else{
            return node.siguiente.dato;
        }
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        if (from == null || cabeza == null){
            return null;
        }
        MiLista nuevaLista = new MiLista();
        ListNode iterador = from;
        ListNode nuevaCabeza = null;
        ListNode ultimo = null;
        while (iterador != null){
            ListNode nuevoNodo = new ListNode(iterador.dato);
            if (nuevaCabeza == null){
                nuevaCabeza = nuevoNodo;
                nuevaLista.cabeza = nuevoNodo;
            }else {
                ultimo.siguiente = nuevoNodo;
            }
            ultimo = nuevoNodo;
            if(iterador == to){
                break;
            }
            iterador = iterador.siguiente;
        }
        return nuevaLista;
    }

    @Override
    public MiLista sortList() {
        if (cabeza == null || cabeza.siguiente == null){
            return this;
        }else{
            ListNode sorted = null;
            ListNode actual = cabeza;
            while (actual != null){
                ListNode next = actual.siguiente;
                if (sorted == null || ((Comparable)actual.dato).compareTo(sorted) < 0){
                    actual.siguiente = sorted;
                    sorted = actual;
                }else {
                    ListNode temp = sorted;
                    while (temp.siguiente != null && ((Comparable)actual.dato).compareTo(temp.siguiente.dato) >= 0){
                        temp = temp.siguiente;
                    }
                    actual.siguiente = temp.siguiente;
                    temp.siguiente = actual;
                }
                actual = next;
            }
            cabeza = sorted;
            return this;
        }

    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
