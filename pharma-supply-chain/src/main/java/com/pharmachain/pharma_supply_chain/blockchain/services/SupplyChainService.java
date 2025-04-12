// SupplyChainService.java
@Service
@RequiredArgsConstructor
public class SupplyChainService {

    private final Web3j web3j;

    @Value("${contract.supply-chain.address}")
    private String contractAddress;

    private SupplyChain contract;

    @PostConstruct
    public void init() throws Exception {
        contract = SupplyChain.load(
                contractAddress,
                web3j,
                credentials,
                Contract.GAS_PRICE,
                Contract.GAS_LIMIT
        );
    }

    public TransactionReceipt addMedicine(
            String name,
            String description,
            BigInteger batchNumber,
            BigInteger expirationDate,
            BigInteger rmsId
    ) throws Exception {
        return contract.addMedicine(
                name,
                description,
                batchNumber,
                expirationDate,
                rmsId
        ).send();
    }

    // Add other wrapper methods...
}