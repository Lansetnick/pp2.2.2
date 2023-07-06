package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarServiceImp CarServiceImp;

    @Autowired
    public CarController(CarServiceImp CarServiceImp) {
        this.CarServiceImp = CarServiceImp;
    }

    @GetMapping
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> carMes = new ArrayList<>();
        carMes.add(new Car("model1", "series1", "carNumber1"));
        carMes.add(new Car("model2", "series2", "carNumber2"));
        carMes.add(new Car("model3", "series3", "carNumber3"));
        carMes.add(new Car("model4", "series4", "carNumber4"));
        carMes.add(new Car("model5", "series5", "carNumber5"));
        if (count == null || count >= 5) {
            model.addAttribute("messagesCars", carMes);
        } else {
            model.addAttribute("messagesCars", CarServiceImp.listCars(carMes, count));
        }
        return "cars";
    }

}
