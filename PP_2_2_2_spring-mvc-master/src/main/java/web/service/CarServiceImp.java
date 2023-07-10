package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {
    @Override
    public List<Car> getlistCars(List<Car> list, int ncars) {
        if (ncars < 5) {
            return list.stream().limit(ncars).collect(Collectors.toList());
        } else {
            return list;
        }
    }

    @Override
    public List<Car> createCars(int num) {
        List<Car> carMes = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            carMes.add(new Car("model"+i, "series"+i, "carNumber"+i));
        }
        /*carMes.add(new Car("model1", "series1", "carNumber1"));
        carMes.add(new Car("model2", "series2", "carNumber2"));
        carMes.add(new Car("model3", "series3", "carNumber3"));
        carMes.add(new Car("model4", "series4", "carNumber4"));
        carMes.add(new Car("model5", "series5", "carNumber5"));*/
        return carMes;
    }
}