package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getlistCars(List<Car> list, int ncars);

    public List<Car> createCars(int num);
}
