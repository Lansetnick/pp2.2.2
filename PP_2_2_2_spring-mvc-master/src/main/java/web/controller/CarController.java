package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import web.service.CarServiceImp;


@Controller
public class CarController {
    private final CarServiceImp CarServiceImp;

    @Autowired
    public CarController(CarServiceImp CarServiceImp) {
        this.CarServiceImp = CarServiceImp;
    }



}
