package editor.cn;

/**
 * Created by Five on 2020/10/24 23:52
 */
interface Flyanimal{
    public void fly();
}
class   Insect {
    int  legnum=6;
}
class  Bird {
    int  legnum=2;
    void egg(){};
}
class Ant extends Insect implements  Flyanimal {
    public void fly(){
        System.out.println("Ant can  fly");
    }
}
class Pigeon extends Bird implements  Flyanimal {
    public void fly(){
        System.out.println("pigeon  can fly");
    }
    public void egg(){
        System.out.println("pigeon  can lay  eggs ");
    }
}
public class InterfaceDemo{
    public static void main(String args[]){
        Ant a=new Ant();
        a.fly();
        System.out.println("Ant's legs are"+ a.legnum);
        Pigeon p= new Pigeon();
        p.fly();
        p.egg();
    }
}
