package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;



@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String printCars(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, ModelMap model) {
        model.addAttribute("messagesCars", carService.getlistCars(carService.createCars(5), count));
        return "cars";
    }
}
