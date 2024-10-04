class Place {
    protected String name;
    protected int population;

    public Place(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public void Show() {
        System.out.println("Місто: " + name + ", Населення: " + population);
    }
}

class Region extends Place {
    private double areaSize;

    public Region(String name, int population, double areaSize) {
        super(name, population);
        this.areaSize = areaSize;
    }

    public void Show() {
        System.out.println("Місто: " + name + ", Населення: " + population + ", Площа:" + areaSize);
    }
}

class City extends Place {
    private boolean isCapital;

    public City(String name, int population, boolean isCapital) {
        super(name, population);
        this.isCapital = isCapital;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void Show() {
        System.out.println("Місто: " + name + ", Населення: " + population + ", Столиця:" + (isCapital ? "Так" : "Ні"));
    }
}

class Metropolis extends City {
    private int numberOfSkyscrapers;

    public Metropolis(String name, int population, boolean isCapital, int numberOfSkyscrapers) {
        super(name, population, isCapital);
        this.numberOfSkyscrapers = numberOfSkyscrapers;
    }

    public void Show() {
        System.out.println("Мегаполіс: " + name + ", Населення: " + population + ", Столиця: " + (isCapital() ? "Так" : "Ні") + ", Хмарочосів: " + numberOfSkyscrapers);
    }
}

public class Main {
    public static void main(String[] args) {
        Place[] places = new Place[4];

        places[0] = new Place("Парк", 0);
        places[1] = new Region("Київська область", 1800000, 28000);
        places[2] = new City("Київ", 3000000, true);
        places[3] = new Metropolis("Нью-Йорк", 8500000, false, 200);

        for (Place place : places) {
            place.Show();
        }
    }
}
