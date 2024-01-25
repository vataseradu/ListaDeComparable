package poo.tema3;

public class Student implements Comparable<Student> {
    private String prenumeStudent;
    private String numeStudent;
    private int prezentaStudent;

    public String getPrenume() {
        return prenumeStudent;
    }

    public void setPrenume(String prenumeStudent) {
        this.prenumeStudent = prenumeStudent;
    }

    public String getNume() {
        return numeStudent;
    }

    public void setNume(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public int getPrezenta() {
        return prezentaStudent;
    }

    public void setPrezenta(int prezentaStudent) {
        this.prezentaStudent = prezentaStudent;
    }

    @Override
    public String toString() {
        return numeStudent + " " + prenumeStudent + "  " + "||  prezenta=" + prezentaStudent;
    }
    @Override
    public int compareTo(Student altStudent) {
        Student studentDeComparat = (Student) altStudent;
        if (this.getPrezenta() > studentDeComparat.getPrezenta()) {
            return 1;
        } else if (this.getPrezenta() < studentDeComparat.getPrezenta()) {
            return -1;
        } else {
            return 0;
        }
    }
}

