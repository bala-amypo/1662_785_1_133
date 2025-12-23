@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryLevelRepository inventoryRepo;
    private final StoreRepository storeRepo;

    public InventoryServiceImpl(InventoryLevelRepository inventoryRepo,
                                StoreRepository storeRepo) {
        this.inventoryRepo = inventoryRepo;
        this.storeRepo = storeRepo;
    }

    @Override
    public List<InventoryLevel> getByStore(Long storeId) {
        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        return inventoryRepo.findByStore(store);
    }
}
