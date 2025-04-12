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
 * Auto-generated web3j wrapper for SupplyChain.sol
 */
@SuppressWarnings("rawtypes")
public class SupplyChain extends Contract {
    public static final String BINARY = "Your compiled contract binary here";

    public static final String FUNC_ADDMEDICINE = "addMedicine";
    public static final String FUNC_ADDDISTRIBUTOR = "addDistributor";
    public static final String FUNC_ADDMANUFACTURER = "addManufacturer";
    public static final String FUNC_ADDRETAILER = "addRetailer";
    public static final String FUNC_ADDRMS = "addRMS";
    public static final String FUNC_CONFIRMRECEIPT = "confirmReceipt";
    public static final String FUNC_GENERATEQRCODE = "generateQRCode";
    public static final String FUNC_GETMEDICINEDETAILS = "getMedicineDetails";
    public static final String FUNC_LOGTRANSPORTDETAILS = "logTransportDetails";
    public static final String FUNC_MARKASSOLD = "markAsSold";
    public static final String FUNC_OWNER = "owner";
    public static final String FUNC_UPDATEDISTRIBUTIONDETAILS = "updateDistributionDetails";
    public static final String FUNC_UPDATEMANUFACTURINGDETAILS = "updateManufacturingDetails";
    public static final String FUNC_UPDATERETAILDETAILS = "updateRetailDetails";
    public static final String FUNC_UPDATESTORAGECONDITIONS = "updateStorageConditions";
    public static final String FUNC_VERIFYPRODUCT = "verifyProduct";

    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addMedicine(String _name, String _description, BigInteger _batchNumber, BigInteger _expirationDate, BigInteger _RMSid) {
        final Function function = new Function(
                FUNC_ADDMEDICINE, 
                Arrays.<Type>asList(new Utf8String(_name), 
                new Utf8String(_description), 
                new Uint256(_batchNumber), 
                new Uint256(_expirationDate), 
                new Uint256(_RMSid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addDistributor(String _address, String _name, String _place) {
        final Function function = new Function(
                FUNC_ADDDISTRIBUTOR, 
                Arrays.<Type>asList(new Address(_address), 
                new Utf8String(_name), 
                new Utf8String(_place)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addManufacturer(String _address, String _name, String _place) {
        final Function function = new Function(
                FUNC_ADDMANUFACTURER, 
                Arrays.<Type>asList(new Address(_address), 
                new Utf8String(_name), 
                new Utf8String(_place)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addRetailer(String _address, String _name, String _place) {
        final Function function = new Function(
                FUNC_ADDRETAILER, 
                Arrays.<Type>asList(new Address(_address), 
                new Utf8String(_name), 
                new Utf8String(_place)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addRMS(String _address, String _name, String _place) {
        final Function function = new Function(
                FUNC_ADDRMS, 
                Arrays.<Type>asList(new Address(_address), 
                new Utf8String(_name), 
                new Utf8String(_place)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> confirmReceipt(BigInteger _id) {
        final Function function = new Function(
                FUNC_CONFIRMRECEIPT, 
                Arrays.<Type>asList(new Uint256(_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> generateQRCode(BigInteger _id, String _qrCode) {
        final Function function = new Function(
                FUNC_GENERATEQRCODE, 
                Arrays.<Type>asList(new Uint256(_id), 
                new Utf8String(_qrCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Medicine> getMedicineDetails(BigInteger _id) {
        final Function function = new Function(FUNC_GETMEDICINEDETAILS, 
                Arrays.<Type>asList(new Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Medicine>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> logTransportDetails(BigInteger _id, BigInteger _DISid) {
        final Function function = new Function(
                FUNC_LOGTRANSPORTDETAILS, 
                Arrays.<Type>asList(new Uint256(_id), 
                new Uint256(_DISid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> markAsSold(BigInteger _id) {
        final Function function = new Function(
                FUNC_MARKASSOLD, 
                Arrays.<Type>asList(new Uint256(_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateDistributionDetails(BigInteger _id, BigInteger _DISid) {
        final Function function = new Function(
                FUNC_UPDATEDISTRIBUTIONDETAILS, 
                Arrays.<Type>asList(new Uint256(_id), 
                new Uint256(_DISid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateManufacturingDetails(BigInteger _id, BigInteger _MANid) {
        final Function function = new Function(
                FUNC_UPDATEMANUFACTURINGDETAILS, 
                Arrays.<Type>asList(new Uint256(_id), 
                new Uint256(_MANid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateRetailDetails(BigInteger _id, BigInteger _RETid) {
        final Function function = new Function(
                FUNC_UPDATERETAILDETAILS, 
                Arrays.<Type>asList(new Uint256(_id), 
                new Uint256(_RETid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateStorageConditions(BigInteger _id, String _conditions) {
        final Function function = new Function(
                FUNC_UPDATESTORAGECONDITIONS, 
                Arrays.<Type>asList(new Uint256(_id), 
                new Utf8String(_conditions)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> verifyProduct(BigInteger _batchId) {
        final Function function = new Function(FUNC_VERIFYPRODUCT, 
                Arrays.<Type>asList(new Uint256(_batchId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class Medicine extends DynamicStruct {
        public BigInteger id;

        public MedicineDetails details;

        public MedicineTracking tracking;

        public Medicine(BigInteger id, MedicineDetails details, MedicineTracking tracking) {
            super(new Uint256(id), details, tracking);
            this.id = id;
            this.details = details;
            this.tracking = tracking;
        }

        public Medicine(Uint256 id, MedicineDetails details, MedicineTracking tracking) {
            super(id, details, tracking);
            this.id = id.getValue();
            this.details = details;
            this.tracking = tracking;
        }
    }

    public static class MedicineDetails extends DynamicStruct {
        public String name;

        public String description;

        public BigInteger batchNumber;

        public BigInteger expirationDate;

        public MedicineDetails(String name, String description, BigInteger batchNumber, BigInteger expirationDate) {
            super(new Utf8String(name), new Utf8String(description), new Uint256(batchNumber), new Uint256(expirationDate));
            this.name = name;
            this.description = description;
            this.batchNumber = batchNumber;
            this.expirationDate = expirationDate;
        }

        public MedicineDetails(Utf8String name, Utf8String description, Uint256 batchNumber, Uint256 expirationDate) {
            super(name, description, batchNumber, expirationDate);
            this.name = name.getValue();
            this.description = description.getValue();
            this.batchNumber = batchNumber.getValue();
            this.expirationDate = expirationDate.getValue();
        }
    }

    public static class MedicineTracking extends DynamicStruct {
        public BigInteger RMSid;

        public BigInteger MANid;

        public BigInteger DISid;

        public BigInteger RETid;

        public String qrCode;

        public String storageConditions;

        public BigInteger stage;

        public MedicineTracking(BigInteger RMSid, BigInteger MANid, BigInteger DISid, BigInteger RETid, String qrCode, String storageConditions, BigInteger stage) {
            super(new Uint256(RMSid), new Uint256(MANid), new Uint256(DISid), new Uint256(RETid), new Utf8String(qrCode), new Utf8String(storageConditions), new Uint256(stage));
            this.RMSid = RMSid;
            this.MANid = MANid;
            this.DISid = DISid;
            this.RETid = RETid;
            this.qrCode = qrCode;
            this.storageConditions = storageConditions;
            this.stage = stage;
        }

        public MedicineTracking(Uint256 RMSid, Uint256 MANid, Uint256 DISid, Uint256 RETid, Utf8String qrCode, Utf8String storageConditions, Uint256 stage) {
            super(RMSid, MANid, DISid, RETid, qrCode, storageConditions, stage);
            this.RMSid = RMSid.getValue();
            this.MANid = MANid.getValue();
            this.DISid = DISid.getValue();
            this.RETid = RETid.getValue();
            this.qrCode = qrCode.getValue();
            this.storageConditions = storageConditions.getValue();
            this.stage = stage.getValue();
        }
    }
}