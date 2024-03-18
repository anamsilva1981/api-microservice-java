package com.apiuser.payrollapi.services;

import com.apiuser.payrollapi.domain.Payroll;
import com.apiuser.payrollapi.feignClients.UserFeign;
import com.apiuser.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workedId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty(
                "local.server.porrt") + " port");
        try {
            var user = feign.findById(workedId).getBody();
            if (Objects.nonNull(user)){
                return  new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                        );
            }

        } catch (FeignException.NotFound ex){
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex){
            throw new IllegalArgumentException("Illegal arument exception");
        }
        return null;
    }
}
