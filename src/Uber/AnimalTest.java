package Uber;

// 基类 Animal
abstract class Animal {
    // 抽象方法 makeSound，子类需要实现该方法
    public abstract void makeSound();
    }

    // Dog 类，继承自 Animal
    class Dog extends Animal {
        // 实现 makeSound 方法
        @Override
        public void makeSound() {
            System.out.println("Bark");
        }
    }

// Cat 类，继承自 Animal
    class Cat extends Animal {
    // 实现 makeSound 方法
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

// 主类，测试不同动物的声音
public class AnimalTest {
    public static void main(String[] args) {
        // 使用多态创建不同的动物
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // 调用 makeSound 方法
        myDog.makeSound();  // 输出 "Bark"
        myCat.makeSound();  // 输出 "Meow"
    }
}
