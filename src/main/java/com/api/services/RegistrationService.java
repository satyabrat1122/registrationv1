package com.api.services;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;


    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;

    }

    public List<RegistrationDto> getRegistration(){
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos = registrations.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
        return dtos;
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

        Registration registration = mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);


        RegistrationDto dto = mapToDto(savedEntity);
        return dto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);

    }


    public RegistrationDto updateRegistration(long id, RegistrationDto registrationDto) {
        Registration r = registrationRepository.findById(id).get();

        r.setName(registrationDto.getName());
        r.setEmail(registrationDto.getEmail());
        r.setMobile(registrationDto.getMobile());
        Registration savedEntity = registrationRepository.save(r);
        RegistrationDto dtos=mapToDto(savedEntity);
        return dtos;
    }


    Registration    mapToEntity(RegistrationDto registrationDto){
        Registration registration=new Registration();
        registration.setName(registrationDto.getName());
        registration.setEmail(registrationDto.getEmail());
        registration.setMobile(registrationDto.getMobile());
        return registration;
    }
    RegistrationDto mapToDto(Registration registration){
        RegistrationDto registrationDto=new RegistrationDto();
        registrationDto.setName(registration.getName());
        registrationDto.setEmail(registration.getEmail());
        registrationDto.setMobile(registration.getMobile());
        return registrationDto;
    }

    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Record not found"));
        return mapToDto(registration);
    }
}
