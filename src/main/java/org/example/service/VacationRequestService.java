package org.example.service;

import org.example.model.VacationRequest;
import org.example.repository.VacationRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationRequestService {

    private final VacationRequestRepository vacationRequestRepository;

    public VacationRequestService(VacationRequestRepository vacationRequestRepository) {
        this.vacationRequestRepository = vacationRequestRepository;
    }

    public List<VacationRequest> findAll() {
        return vacationRequestRepository.findAll();
    }

    public void createVacationRequest(String username, String startDate, String endDate) {
        VacationRequest vacationRequest = new VacationRequest(username, startDate, endDate, "PENDING");
        vacationRequestRepository.save(vacationRequest);
    }

    public void approveRequest(String id) {
        VacationRequest vacationRequest = vacationRequestRepository.findById(id).orElseThrow();
        vacationRequest.setStatus("APPROVED");
        vacationRequestRepository.save(vacationRequest);
    }

    public void rejectRequest(String id) {
        VacationRequest vacationRequest = vacationRequestRepository.findById(id).orElseThrow();
        vacationRequest.setStatus("REJECTED");
        vacationRequestRepository.save(vacationRequest);
    }
}
