package main.java.com.pharmachain.pharma_supply_chain.blockchain.contracts;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Auto-generated web3j wrapper for Roles.sol
 */
@SuppressWarnings("rawtypes")
public class Roles extends Contract {
    public static final String BINARY = "Your compiled contract binary here";

    public static final String FUNC_ADMIN = "admin";
    public static final String FUNC_ASSIGNROLE = "assignRole";
    public static final String FUNC_GETROLEDESCRIPTION = "getRoleDescription";
    public static final String FUNC_GETUSERROLE = "getUserRole";
    public static final String FUNC_HASROLE = "hasRole";
    public static final String FUNC_REVOKEROLE = "revokeRole";
    public static final String FUNC_TRANSFERADMIN = "transferAdmin";
    public static final String FUNC_USERROLES = "userRoles";

    @Deprecated
    protected Roles(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Roles(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Roles(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Roles(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> assignRole(String _user, BigInteger _role) {
        final Function function = new Function(
                FUNC_ASSIGNROLE, 
                Arrays.<Type>asList(new Address(_user), new Uint256(_role)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getRoleDescription(BigInteger _role) {
        final Function function = new Function(FUNC_GETROLEDESCRIPTION, 
                Arrays.<Type>asList(new Uint256(_role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getUserRole(String _user) {
        final Function function = new Function(FUNC_GETUSERROLE, 
                Arrays.<Type>asList(new Address(_user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Boolean> hasRole(String _user, BigInteger _role) {
        final Function function = new Function(FUNC_HASROLE, 
                Arrays.<Type>asList(new Address(_user), new Uint256(_role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeRole(String _user) {
        final Function function = new Function(
                FUNC_REVOKEROLE, 
                Arrays.<Type>asList(new Address(_user)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferAdmin(String _newAdmin) {
        final Function function = new Function(
                FUNC_TRANSFERADMIN, 
                Arrays.<Type>asList(new Address(_newAdmin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> userRoles(String param0) {
        final Function function = new Function(FUNC_USERROLES, 
                Arrays.<Type>asList(new Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<Roles> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Roles.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Roles> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Roles.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    public static Roles load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Roles(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Roles load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Roles(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}