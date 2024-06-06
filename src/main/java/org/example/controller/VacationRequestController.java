package org.example.controller;

import org.example.model.VacationRequest;
import org.example.service.VacationRequestService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/vacation_requests")
public class VacationRequestController {

    private final VacationRequestService vacationRequestService;

    public VacationRequestController(VacationRequestService vacationRequestService) {
        this.vacationRequestService = vacationRequestService;
    }

    @GetMapping
    public String getVacationRequests(Model model, Authentication authentication) {
        List<VacationRequest> requests = vacationRequestService.findAll();
        model.addAttribute("requests", requests);
        model.addAttribute("isAdmin", isAdmin(authentication));
        return "vacation_requests";
    }

    @GetMapping("/submit")
    public String submitVacationRequestForm() {
        return "submit_vacation_request";
    }

    @PostMapping("/submit")
    public String submitVacationRequest(@RequestParam String startDate, @RequestParam String endDate, Authentication authentication) {
        String username = authentication.getName();
        vacationRequestService.createVacationRequest(username, startDate, endDate);
        return "redirect:/vacation_requests";
    }

    @PostMapping("/approve")
    public String approveVacationRequest(@RequestParam String id) {
        vacationRequestService.approveRequest(id);
        return "redirect:/vacation_requests";
    }

    @PostMapping("/reject")
    public String rejectVacationRequest(@RequestParam String id) {
        vacationRequestService.rejectRequest(id);
        return "redirect:/vacation_requests";
    }

    private boolean isAdmin(Authentication authentication) {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        return roles.contains("ROLE_ADMIN");
    }
    @RestController
    @RequestMapping("/api/vacation_requests")
    public static class VacationRequestApiController {

        private final VacationRequestService vacationRequestService;

        public VacationRequestApiController(VacationRequestService vacationRequestService) {
            this.vacationRequestService = vacationRequestService;
        }

        @GetMapping
        public List<VacationRequest> getAllVacationRequests() {
            return vacationRequestService.findAll();
        }
    }

}
