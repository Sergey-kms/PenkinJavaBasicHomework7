package ru.java.basic.penkin.homework7;

class Human {      // В гитхаб branch2
    private String name;
    private Transport currentTransport;
    private int endurance;

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public void reduceEndurance(int value) {
        endurance -= value;
    }

    public void setCurrentTransport(Transport transport) {
        this.currentTransport = transport;
    }

    public boolean move(int distance, TerrainTypes terrainType) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrainType, this);
        } else {
            if (currentTransport instanceof Bicycle) {
                return ((Bicycle) currentTransport).move(distance, terrainType, this);
            } else {
                System.out.println(name + " идет пешком " + distance + " километров по " + terrainType);
                return true;
            }
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

enum TerrainTypes {      // Перечисление (enum) разных типов местности. На лекции было сказано, что перечисление должны быть с заглавных букв и, видимо, перечисление надо делать на английском.
    DENSEFOREST,
    PLAIN,
    SWAMP
}

interface Transport {               // Интерфейс для транспорта
    boolean move(int distance, TerrainTypes terrainType, Human driver);
}

class Car implements Transport {   // Класс Машина
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, TerrainTypes terrainType, Human driver) {
        if (terrainType == TerrainTypes.DENSEFOREST || terrainType == TerrainTypes.SWAMP) {
            System.out.println("Машина не может ехать по " + terrainType);
            return false;
        }

        int fuelConsumption = distance / 10;
        if (fuel >= fuelConsumption) {
            fuel -= fuelConsumption;
            System.out.println("Машина проехала " + distance + " километров по " + terrainType + " с водителем " + driver.getName());
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
    public boolean move(int distance, TerrainTypes terrainType, Human driver) {
        if (terrainType == TerrainTypes.SWAMP) {
            System.out.println("Лошадь с ездоком не может передвигаться по " + terrainType);
            return false;
        }

        int energyConsumption = distance / 5;
        if (energy >= energyConsumption) {
            energy -= energyConsumption;
            System.out.println("Лошадь проскакала " + distance + " километров по " + terrainType + " с ездоком " + driver.getName());
            return true;
        } else {
            System.out.println("У лошади недостаточно энергии, чтобы двигаться дальше");
            return false;
        }
    }
}

class OffRoadCar implements Transport {   // Класс Вездеход
    @Override
    public boolean move(int distance, TerrainTypes terrainType, Human driver) {
        System.out.println("Вездеход проехал " + distance + " километров по " + terrainType + " с водителем " + driver.getName());
        return true;
    }
}

class Bicycle implements Transport {   // Класс Велосипед
    private int humanEnergy;

    public Bicycle(int humanEnergy) {
        this.humanEnergy = humanEnergy;
    }

    @Override
    public boolean move(int distance, TerrainTypes terrainType, Human driver) {
        if (terrainType == TerrainTypes.SWAMP) {
            System.out.println("Велосипед не может двигаться по " + terrainType);
            return false;
        }

        int energyConsumption = distance / 2;
        if (driver.getEndurance() >= energyConsumption) {
            driver.reduceEndurance(energyConsumption);
            System.out.println("Человек на велосипеде проехал " + distance + " километров по " + terrainType + " с водителем " + driver.getName());
            return true;
        } else {
            System.out.println("У человека нет сил, чтобы ехать дальше на велосипеде");
            return false;
        }
    }
}