package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void CancelFlight(Long id){
        flightRepository.deleteById(id);
    }

    public Flight addPassengerToFlight(long flightId, Passenger passenger){
        Flight flight = flightRepository.findById(flightId).get();
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        flightRepository.save(flight);
        return flight;
    }
}
