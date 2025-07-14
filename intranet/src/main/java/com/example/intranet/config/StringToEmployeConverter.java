package com.example.intranet.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.intranet.model.Employe;
import com.example.intranet.repository.EmployeRepository;

@Component
public class StringToEmployeConverter implements Converter<String, Employe> {

    private final EmployeRepository employeRepository;

    public StringToEmployeConverter(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public Employe convert(String id) {
        try {
            Long employeId = Long.valueOf(id);
            return employeRepository.findById(employeId).orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
