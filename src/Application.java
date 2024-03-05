import java.util.*;
class Bobr implements Comparable<Bobr> {
 String name;
 int age;
 Bobr(String name,int age) {
 this.name = name;
 this.age = age;
 }
 @Override
    public int compareTo(Bobr b) {
     return (int) this.age - b.age;
 }
 @Override
    public boolean equals(Object o) {
     if (o==null || o.getClass()!=this.getClass()) { return false;}
     Bobr obj = (Bobr) o;
return this.age==obj.age && this.name==obj.name;
}
@Override
    public int hashCode() {
return 31*31*this.name.hashCode()*this.age;
}
}
class BobrComparator implements Comparator<Bobr> {
    @Override
    public int  compare(Bobr b1,Bobr b2) {
        return b1.compareTo(b2);
    }
}
public class Application {
public static void main(String[] args) {
    System.out.println("Приложение работает");
   // Создаем список из бобров
    List<Bobr> bobrs = new ArrayList();
    bobrs.add(new Bobr("Gena",5));
    bobrs.add(new Bobr("Volodya",15));
    bobrs.add(new Bobr("Anna",1));
    bobrs.add(new Bobr("Masha",55));
    // Сортировка по возрасту
    Collections.sort(bobrs);
for (Bobr f : bobrs) {
    System.out.println(f.name);
}
// Сортировка по имени
    System.out.println("Сортировка по имени");
Collections.sort(bobrs, new BobrComparator());
for (Bobr b : bobrs) {
    System.out.println(b.name+" "+b.age);
}
System.out.println("Теперь добавим бобров в set мешок и поищим в мешке наших бобров");
Set<Bobr> hashSet = new HashSet<>();
Iterator<Bobr> i = bobrs.iterator();
while (i.hasNext()) {
    hashSet.add(i.next());
}
System.out.println("Бобры добавлены, теперь проверим, есть ли они или нет.");
Iterator<Bobr> test = bobrs.iterator();
while (test.hasNext()) {
Bobr whileBobr = test.next();
Iterator<Bobr> hsi = hashSet.iterator();
String result = whileBobr.name+": ";
while (hsi.hasNext()) {
if (whileBobr.equals(hsi.next())) {
    System.out.println(whileBobr.name+": Есть в корзине");
}

}



}


}
}
