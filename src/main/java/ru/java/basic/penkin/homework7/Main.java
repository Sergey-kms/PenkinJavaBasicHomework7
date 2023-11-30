package ru.java.basic.penkin.homework7;

public class Main {           // В гитхаб branch2
    public static void main(String[] args) {
        Human human = new Human("Владимир");

        Car car = new Car(20);
        human.setCurrentTransport(car);
        human.move(120, TerrainType.PLAIN);
        human.getOffTransport();

        human.move(5, TerrainType.PLAIN);

        Horse horse = new Horse(100);
        human.setCurrentTransport(horse);
        human.move(15, TerrainType.DENSEFOREST);
        human.move(10, TerrainType.SWAMP);
        human.getOffTransport();


        OffRoadCar offRoadcar = new OffRoadCar(10);
        human.setCurrentTransport(offRoadcar);
        human.move(40, TerrainType.SWAMP);
        human.getOffTransport();

        Bicycle bicycle = new Bicycle(60);
        human.setCurrentTransport(bicycle);
        human.move(50, TerrainType.PLAIN);
        human.move(100, TerrainType.PLAIN);

    }
}