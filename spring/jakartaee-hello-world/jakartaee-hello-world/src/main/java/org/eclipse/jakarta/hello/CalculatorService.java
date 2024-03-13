package org.eclipse.jakarta.hello;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface CalculatorService {
    @WebMethod
    int add(int a, int b);
}
