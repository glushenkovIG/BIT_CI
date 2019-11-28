package hello;

class MyApplication {
    private RBK rbk;

    MyApplication(RBK rbk1) {
        this.rbk = rbk1;
    }

    void printCourse() {
        System.out.println(rbk.getMax());
    }
}