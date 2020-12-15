public class Main {
    public static void main(String [] args){
      MyClass1 myClass1 = (new Injector<MyClass1>()).inject(new MyClass1());
      myClass1.myClass2.testMetodClass();
      myClass1.myClass3.testMetodClass();
    }
}
