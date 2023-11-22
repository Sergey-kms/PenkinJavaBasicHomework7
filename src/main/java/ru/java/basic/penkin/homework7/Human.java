package ru.java.basic.penkin.homework7;

class Human {          // В гитхаб branch1
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCurrentTransport(Transport transport) {
        this.currentTransport = transport;
    }

    public boolean move(int distance, TerrainType terrainType) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrainType);
        } else {
            System.out.println(name + " идет пешком " + distance + " километров по " + terrainType);
            return true;
        }
    }

    public void getOffTransport() {
        if (currentTransport != null) {
            currentTransport = null;
            System.out.println(name + " сошел с транспорта");
        } else {
            System.out.println(name + " не сидит ни в транспорте, ни на лошади");
        }
    }
}

enum TerrainType {      // Перечисление (enum) разных типов местности. На лекции было сказано, что перечисление должны быть с заглавных букв и, видимо, перечисление надо делать на английском.
    DENSEFOREST,
    PLAIN,
    SWAMP
}

interface Transport {               // Интерфейс для транспорта
    boolean move(int distance, TerrainType terrainType);
}

class Car implements Transport {   // Класс Машина

    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.DENSEFOREST || terrainType == TerrainType.SWAMP) {
            System.out.println("Машина не может ехать по " + terrainType);
            return false;
        }

        int fuelConsumption = distance / 10;
        if (fuel >= fuelConsumption) {
            fuel -= fuelConsumption;
            System.out.println("Машина проехала " + distance + " километров по " + terrainType);
            return true;
        } else {
            System.out.println("У машины закончилось топливо");
            return false;
        }
    }
}

class Horse implements Transport {       // Класс Лошадь
    private int energy;

    public Horse(int energy) {
        this.energy = energy;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Лошадь с ездоком не может передвигаться по " + terrainType);
            return false;
        }

        int energyConsumption = distance / 5;
        if (energy >= energyConsumption) {
            energy -= energyConsumption;
            System.out.println("Лошадь с ездоком проскакала " + distance + " километров по " + terrainType);
            return true;
        } else {
            System.out.println("У лошади недостаточно энергии, чтобы двигаться дальше");
            return false;
        }
    }
}

class OffRoadCar implements Transport {   // Класс Вездеход
    private int fuel;

    public OffRoadCar(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        System.out.println("Вездеход проехал " + distance + " километров по " + terrainType);
        return true;
    }
}

class Bicycle implements Transport {   // Класс Велосипед

    private int humanEnergy;

    public Bicycle(int humanEnergy) {
        this.humanEnergy = humanEnergy;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Велосипед не может двигаться по " + terrainType);
            return false;
        }

        int energyConsumption = distance / 2;
        if (humanEnergy >= energyConsumption) {
            humanEnergy -= energyConsumption;
            System.out.println("Человек на велосипеде проехал " + distance + " километров по " + terrainType);
            return true;
        } else {
            System.out.println("У человека нет сил, чтобы ехать дальше на велосипеде");
            return false;
        }
    }
}