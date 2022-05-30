public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("========YENİ ROUND========");
                int hitByWho = (int) (Math.random() * 2);
                if (hitByWho == 0) {
                    this.f2.health = f1.hit(f2);
                    if (isWin()) {

                        break;
                    }

                } else {
                    this.f1.health = f2.hit(f1);
                    if (isWin()) {

                        break;
                    }
                }
                System.out.println(f2.name + " sporcusunun kalan sağlığı " + f2.health);
                System.out.println(f1.name + " sporcusunun kalan sağlığı " + f1.health);
            }
        } else {
            System.out.println("Sporcuların sikletleri uymuyor !");
        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " kazandı !");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " kazandı !");
            return true;
        }
        return false;
    }
}
