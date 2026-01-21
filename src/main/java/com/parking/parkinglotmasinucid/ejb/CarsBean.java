package com.parking.parkinglotmasinucid.ejb;

import com.parking.parkinglotmasinucid.common.CarDto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import com.parking.parkinglotmasinucid.entities.Car;
import com.parking.parkinglotmasinucid.entities.User;

import java.util.ArrayList;
import java.util.Collection;
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



    public void createCar(String licensePlate, String parkingSpot,Long userId){
        LOG.info("createCar");

        Car car=new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user= entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        entityManager.persist(car);
    }

    public CarDto findById(Long carId) {
        Car car = entityManager.find(Car.class, carId);

        if (car == null) {
            return null;
        }
        CarDto carDto=new CarDto(car.getId(),car.getLicensePlate(),car.getParkingSpot(),car.getOwner().getUsername());
        return carDto;
    }


    public void updateCar(Long carId,String licensePlate, String parkingSpot, Long userId){
        LOG.info("updateCar");

        Car car= entityManager.find(Car.class,carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User oldUser=car.getOwner();
        oldUser.getCars().remove(car);

        User user=entityManager.find(User.class,userId);
        user.getCars().add(car);
        car.setOwner(user);
    }

    public void deleteCarsByIds(Collection<Long> carIds){
        LOG.info("deleteCarsByIds");

        for(Long carId:carIds){
            Car car=entityManager.find(Car.class,carId);
            entityManager.remove(car);
        }
    }
}

