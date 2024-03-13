package org.eclipse.jakarta.hello;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
public interface AccountWS {

    @WebMethod
    Account createAccount(@WebParam(name = "name") String name, @WebParam(name = "initialBalance")  double initialBalance);

    @WebMethod
    boolean withdraw(@WebParam(name = "accountId") int accountId, @WebParam(name = "amount") double amount);

    @WebMethod
    boolean deposit(@WebParam(name = "accountId") int accountId, @WebParam(name = "amount") double amount);

    @WebMethod
    Account findAccountByName(@WebParam(name = "name") String name);
}
