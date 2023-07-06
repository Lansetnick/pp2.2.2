package web.service;

import org.springframework.stereotype.Controller;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarServiceImp implements CarService{
    @Override
    public List<Car> listCars(List<Car> list, int ncars) {
        if (ncars < 5) {
            return list.stream().limit(ncars).collect(Collectors.toList());
        } else {
            return list;
        }
    }
}