package com.parking.parkinglotmasinucid.ejb;

import com.parking.parkinglotmasinucid.common.CarDto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.entities.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {

    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;


    public List<CarDto> findAllCars(){
        LOG.info("findAllCars");
        try{
            TypedQuery<Car> typedQuery =
                    entityManager.createQuery("SELECT c FROM Car c", Car.class);
            typedQuery.getResultList();
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CarDto> copyCarsToDto(List<Car> carList){
        List<CarDto> carDtoList=new ArrayList<>();
        for(Car car:carList){
            CarDto carDto=new CarDto(car.getId(),car.getLicensePlate(),car.getParkingSpot(),car.getOwner().getUsername());
            carDtoList.add(carDto);
        }
        return carDtoList;
    }
}

