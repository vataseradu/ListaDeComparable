package poo.util;

public class ListaDeComparable<T extends Comparable> {
    T[] elementeLista;
    int dimensiuneaMaxima;
    int numarCurentDeElemente;

    public ListaDeComparable(Class<T> _itemClassType, int dimensiuneMaxima) {
        elementeLista = (T[]) java.lang.reflect.Array.newInstance(
                _itemClassType, dimensiuneMaxima);
        this.dimensiuneaMaxima = dimensiuneMaxima;
    }

    public String afisareElemente() throws ExceptieListaGoala {
        if (numarCurentDeElemente == 0) {
            throw new ExceptieListaGoala("Lista este goala");
        } else {
            String elemente = "";
            for (int i = 0; i < numarCurentDeElemente; i++) {
                elemente = elemente + elementeLista[i] + " " + "\n"; // afisare cu new line ..
            }
            return elemente;
        }
    }

    public void adaugareElemente(T element) throws ExceptieListaPlina {
        if (numarCurentDeElemente == dimensiuneaMaxima) {
            throw new ExceptieListaPlina("Lista este plina");
        } else {
            elementeLista[numarCurentDeElemente] = element;
            numarCurentDeElemente++;
        }
    }

    public void eliminareElemente() throws ExceptieListaGoala {
        if (numarCurentDeElemente == 0) {
            throw new ExceptieListaGoala("Lista este goala");
        } else {
            for (int i = 0; i < numarCurentDeElemente - 1; i++) {
                elementeLista[i] = elementeLista[i + 1];
            }
            numarCurentDeElemente--;
        }
    }

    public void sortareElemente() throws ExceptieListaGoala {
        if (numarCurentDeElemente == 0) {
            throw new ExceptieListaGoala("Lista este goala");
        } else {
            for (int i = 0; i < numarCurentDeElemente - 1; i++) {
                for (int j = i + 1; j < numarCurentDeElemente; j++) {
                    if (elementeLista[i].compareTo(elementeLista[j]) < 0) {
                        T aux = elementeLista[i];
                        elementeLista[i] = elementeLista[j];
                        elementeLista[j] = aux;
                    }
                }
            }
        }
    }
}



