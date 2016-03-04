package br.israelbgf.pointofsale;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {

    Map<String, Product> products = new HashMap<>();

    @Override
    public void save(Product product) {
        products.put(product.barcode, product);
    }

    @Override
    public Product findBy(String barcode) {
        if(products.containsKey(barcode))
            return products.get(barcode);
        else
            throw new ProductNotFoundException();
    }

}
