public class Child extends Parent {
    public void printParent() {
        System.out.println("ini adalah kelas child");
    }

    public static void main(String[] args) {
        String nama = "agus";
        nama = "indah";
        Child anak = new Child();
        anak.printParent();
    }
}
