package com.pharmachain.pharma_supply_chain.service;

import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;
import java.math.BigInteger;

@Service
public class BlockchainService {
    private final Web3j web3j;
    private final Credentials credentials;
    private final SupplyChain contract;

    public BlockchainService(Web3j web3j,
                             Credentials credentials,
                             @Value("${contract.supply-chain.address}") String contractAddress) throws Exception {
        this.web3j = web3j;
        this.credentials = credentials;
        this.contract = SupplyChain.load(
                contractAddress,
                web3j,
                credentials,
                new DefaultGasProvider()
        );
    }

    /**
     * Log data on the blockchain
     * @param batchId The batch ID to log
     * @param data The data to log
     * @return Transaction receipt
     */
    public TransactionReceipt logData(String batchId, String data) throws Exception {
        try {
            TransactionReceipt receipt = contract.logBatchData(
                    batchId,
                    data,
                    credentials.getAddress()
            ).send();

            System.out.println("Data logged on blockchain: " + receipt.getTransactionHash());
            return receipt;
        } catch (Exception e) {
            System.err.println("Error logging data on blockchain: " + e.getMessage());
            throw new RuntimeException("Failed to log data on blockchain", e);
        }
    }

    /**
     * Retrieve data from the blockchain
     * @param batchId The batch ID to retrieve
     * @return Retrieved data as string
     */
    public String getData(String batchId) throws Exception {
        try {
            String data = contract.getBatchData(batchId).send();
            System.out.println("Data retrieved from blockchain: " + data);
            return data;
        } catch (Exception e) {
            System.err.println("Error retrieving data from blockchain: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve data from blockchain", e);
        }
    }

    /**
     * Update data on the blockchain
     * @param batchId The batch ID to update
     * @param updatedData The updated data
     * @return Transaction receipt
     */
    public TransactionReceipt updateData(String batchId, String updatedData) throws Exception {
        try {
            TransactionReceipt receipt = contract.updateBatchData(
                    batchId,
                    updatedData,
                    credentials.getAddress()
            ).send();

            System.out.println("Data updated on blockchain: " + receipt.getTransactionHash());
            return receipt;
        } catch (Exception e) {
            System.err.println("Error updating data on blockchain: " + e.getMessage());
            throw new RuntimeException("Failed to update data on blockchain", e);
        }
    }
}