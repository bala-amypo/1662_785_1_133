@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public Store create(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @GetMapping("/{id}")
    public Store get(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @GetMapping
    public List<Store> getAll() {
        return storeService.getAllStores();
    }
}
