package web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestMapping("/cars")
public class CarServiceImp implements CarService {
    @Override
    public List<Car> getlistCars(List<Car> list, int ncars) {
        if (ncars < 5) {
            return list.stream().limit(ncars).collect(Collectors.toList());
        } else {
            return list;
        }
    }

    @GetMapping
    public String printCars(Integer count, ModelMap model) {
        List<Car> carMes = new ArrayList<>();
        carMes.add(new Car("model1", "series1", "carNumber1"));
        carMes.add(new Car("model2", "series2", "carNumber2"));
        carMes.add(new Car("model3", "series3", "carNumber3"));
        carMes.add(new Car("model4", "series4", "carNumber4"));
        carMes.add(new Car("model5", "series5", "carNumber5"));
        if (count == null || count >= 5) {
            model.addAttribute("messagesCars", carMes);
        } else {
            model.addAttribute("messagesCars", getlistCars(carMes, count));
        }
        return "cars";
    }
}