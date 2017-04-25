import sun.security.x509.CertAttrSet;

/**
 * @author 郭若辰
 * @create 2017-04-25 13:46
 */
public class DuoTaiTest {

    public static void main(String[] args) {
        Animal animal = new Dog();//向上转型
        Pet pet = new Dog();//向上转型
        //!animal.guard(); 父类引用不能调用子类特有方法
        //!System.out.println(animal.age); 父类引用不能调用子类特有属性
        //!pet.guard(); 接口引用不能调用实现类特有方法
        //!System.out.println(pet.age); 接口引用不能调用实现类特有变量
        System.out.println(animal.size); //父类引用默认访问同名的父类变量,多态失效
        System.out.println(pet.PRICE);//接口引用默认访问同名的接口变量，多态失效
        animal.aa();//父类引用默认调用父类中的静态方法，多态失效

        //实际上，多态只是在调用子类覆盖后的非静态方法时才会生效！！！！


        //数组的类型检查是在运行时进行的，所以数组的多态可以通过编译器的检查
        Animal[] arr_dog=new Dog[]{new Dog(),new Dog()};
        Animal[] arr_cat=new Cat[]{new Cat(),new Cat()};
        //但是数组的多态是有风险的，如果将不同子类的对象放进数组，会出现ArrayStoreException
        //arr_dog[0]=new Cat();
        //arr_cat[0]=new Dog();
        //容器类的类型检查是在编译期进行的，所以容器类没有多态
        //!ArrayList<Animal> list=new ArrayList<Dog>();

        //多态的好处：提高程序可扩展性
        DuoTaiTest dt=new DuoTaiTest();
        dt.doEat(animal);//编译器调用的是Animal引用作为形参的版本
        dt.doPlay(pet);//编译器调用的是Pet引用作为形参的版本
        dt.doEat(new Dog());//编译器调用的是Dog引用作为形参的版本
        dt.doEat(new Cat());//编译器调用的是Cat引用作为形参的版本
        dt.doPlay(new Dog());//编译器调用的是Dog引用作为形参的版本
        dt.doPlay(new Cat());//编译器调用的是Cat引用作为形参的版本

        Animal a = dt.fanHuiAnimal();
        if (a instanceof Dog){
            Dog dog = (Dog)a;
            dog.guard();
        }
        Pet p = dt.fanHuiPet();
        if (a instanceof Dog){
            Dog dog = (Dog)p;
            dog.guard();
        }


    }

    //如果这样定义方法，不利于程序的可扩展性
    public void doEat(Dog dog){
        dog.eat();
    }
    public void doEat(Cat cat){
        cat.eat();
    }
    public void doPlay(Dog dog){
        dog.play();
    }
    public void doPlay(Cat cat){
        cat.play();
    }
    public Dog fanHuiDog(){
        return new Dog();
    }
    public Cat fanHuiCat(){
        return new Cat();
    }
    //... （如果添加了新的动物，这里又要新添很多方法，不利于系统维护）

    //利用多态，可以提高程序的可扩展性
    //将方法的参数列表设置为父类或接口的引用
    public void doEat(Animal animal){//Animal animal=new Dog()/new Cat()...
        animal.eat();
        System.out.println("利用多态");
    }
    public void doPlay(Pet pet){//Pet pet=new Dog()/new Cat()...
        pet.play();
        System.out.println("利用多态");
    }
    //将返回值类型设置为父类或接口
    public Animal fanHuiAnimal(){//Animal animal=new Dog()/new Cat()...
        return new Dog();
        //return new Cat();
        //...
    }
    public Pet fanHuiPet(){//Pet pet=new Dog()/new Cat()...
        return new Dog();
        //return new Cat();
        //...
    }
}

abstract class Animal {
    int size = 0;

    public void eat() {
        System.out.println("吃东西");
    }

    public static void aa() {
        System.out.println("父类静态方法");
    }
}

interface Pet {
    int PRICE = 100;

    void play();
}

class Dog extends Animal implements Pet {
    //与父类和接口同名变量
    int size = 1;
    int PRICE = 200;
    //特有变量
    int age;

    public void eat() {
        System.out.println("啃骨头");
    }

    @Override
    public void play() {
        System.out.println("陪主人玩");
    }

    //特有方法
    public void guard(){
        System.out.println("保护主人");
    }

    //覆盖父类的静态方法（实际上这里并没有被覆盖）
    public static void aa() {
        System.out.println("子类的静态方法");
    }
}

class Cat extends Animal implements Pet {
    public void eat() {
        System.out.println("吃鱼");
    }

    public void play() {
        System.out.println("抓老鼠玩");
    }
}