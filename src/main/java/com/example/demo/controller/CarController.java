package com.example.demo.controller;

import com.example.demo.bean.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Validated
public class CarController {

        @RequestMapping(value = "/findCar" , method = RequestMethod.GET)
       public Car findOne(){
               Car car = new Car(12,"lan",123f,new Date(),"","");
               return car;
       }

       @RequestMapping(value = "/findAll" , method = RequestMethod.GET)
       public List<Car> findAll(){
               List<Car> list=new ArrayList<>();
               Car car1 = new Car(1, "兰博基尼", 1999.99F,new Date(),"","");
               Car car2= new Car(2, "法拉利", 2999.99F,new Date(),"","");
               Car car3 = new Car(3, "奔驰", 3999.99F,new Date(),"","");
               Car car4 = new Car(4, "阿波罗", 4999.99F,new Date(),"","");

               list.add(car1);
               list.add(car2);
               list.add(car3);
               list.add(car4);

               return list;
       }

       @RequestMapping(value = "/getCar2/{name}" , method = RequestMethod.GET)
       public Car getCar2(@PathVariable(name = "name") String name, @RequestParam(name = "webID") Integer id){
               Car car = new Car(id,name,123f,new Date(),"","");
               return car;
       }

       @GetMapping("/getCar3")
       public Car getCar3(@RequestBody Car car){
                return car;
       }

       public void testToEat(){
                System.out.println("to eat");
       }

       @GetMapping("/getCar4")
       public  Car getCar4(Car car){
                return car;
       }

       public String test(){
                return "i change the retur----- demo2";
       }

       @InitBinder
       private void initBinder(WebDataBinder webDataBinder){
                webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
       }

        @RequestMapping("/valid1/{group:[1-9a-zA-Z_]+}/{userid}")
        public String valid1(@PathVariable("group") String group,@PathVariable("userid") String userid){
                return group + "&&&&&&&&&-------->" + userid;
        }

        @RequestMapping("/valid2")
        public String valid2(@NotBlank(message = "email不能为空") @Email(message = "不符合邮箱规范")
                                     @RequestParam("ema") String email ,
                             @NotBlank(message = "group不能为空")
                                     @RequestParam("grp") String group){
                return email + "------------->" + group;
        }


}
