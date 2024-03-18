package com.apiuser.payrollapi.resources;

import com.apiuser.payrollapi.domain.Payroll;
import com.apiuser.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping( value = "/api/payments")
public class PayrollResource {

    private final PayrollService service;
    @GetMapping(value = "/{workedId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workedId,
                                              @RequestBody Payroll payment){

        return ResponseEntity.ok().body(service.getPayment(workedId, payment));


    }
}
