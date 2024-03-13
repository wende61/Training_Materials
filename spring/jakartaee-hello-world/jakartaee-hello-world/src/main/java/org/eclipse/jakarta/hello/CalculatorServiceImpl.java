package org.eclipse.jakarta.hello;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.eclipse.jakarta.hello.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
