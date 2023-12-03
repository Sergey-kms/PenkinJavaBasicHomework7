package ru.java.basic.penkin.homework7;

public class Main {      // В гитхаб branch2
    public static void main(String[] args) {
        Human human = new Human("Владимир", 50);

        Car car = new Car(20);
        human.setCurrentTransport(car);
        human.move(120, TerrainTypes.PLAIN);
        human.getOffTransport();

        human.move(5, TerrainTypes.PLAIN);

        Horse horse = new Horse(100);
        human.setCurrentTransport(horse);
        human.move(15, TerrainTypes.DENSEFOREST);
        human.move(10, TerrainTypes.SWAMP);
        human.getOffTransport();

        OffRoadCar offRoadcar = new OffRoadCar();
        human.setCurrentTransport(offRoadcar);
        human.move(40, TerrainTypes.SWAMP);
        human.getOffTransport();

        Bicycle bicycle = new Bicycle(60);
        human.setCurrentTransport(bicycle);
        human.move(50, TerrainTypes.PLAIN);
        human.move(100, TerrainTypes.PLAIN);
    }
}