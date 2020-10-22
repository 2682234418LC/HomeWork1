package Test_1;

import java.util.*;

/**
 * 此类为方法类
 * 封装增删改查操作的代码
 */
public class CRUDS {
    List<Animal> list = new ArrayList<>();

    Animal animal = null;

    public CRUDS() {
        list.add(new Animal("兔子", 18, "雄"));
        list.add(new Animal("老鼠", 14, "雌性"));
        list.add(new Animal("长颈鹿", 25, "雄"));
        list.add(new Animal("乌龟", 80, "雌"));
    }

    public void add(Animal animal) {

        list.add(animal);
        System.out.println("增加完毕，当前动物表为：");
        sort(list);
    }

    public void delete(String Kind) {
        Iterator<Animal> it = list.iterator();
        while (it.hasNext()) {
            animal = it.next();
            if (animal.getKind().equals(Kind)) {
                it.remove();
                break;
            } else if (!it.hasNext()){
                System.out.println("动物表中没有您想要删除的动物");
            }
        }
        sort(list);
    }

    public void update(String kind1, String kind2, int age, String sex) {
        Iterator<Animal> it = list.iterator();
        while (it.hasNext()) {
            animal = it.next();
            if (animal.getKind().equals(kind1)) {
                animal.setKind(kind2);
                animal.setSex(sex);
                animal.setAge(age);
            }
        }
        sort(list);
    }

    public void query(String kind) {
        Iterator<Animal> it = list.iterator();
        while (it.hasNext()) {
            animal = it.next();
            if (animal.getKind().equals(kind)) {
                System.out.println("***" + animal.getKind() + "***" + animal.getAge() + "岁***" + animal.getSex());
            }
        }
    }

    public void sort(List list) {
        Collections.sort(list, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Animal animal = (Animal) list.get(i);
            System.out.println("***" + animal.getKind() + "***" + animal.getAge() + "岁***" + animal.getSex());
        }
    }
}
