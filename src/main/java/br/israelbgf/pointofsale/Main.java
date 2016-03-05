package br.israelbgf.pointofsale;

import br.israelbgf.pointofsale.entity.Product;
import br.israelbgf.pointofsale.gateway.InMemoryProductRepository;
import br.israelbgf.pointofsale.usecase.DisplayProductFromBarcode;

public class Main {

    public static void main(String[] args) {
        InMemoryProductRepository repository = new InMemoryProductRepository();
        repository.save(new Product("1234", 91.19));
        repository.save(new Product("4321", 19.91));

        new DisplayProductFromBarcode(System.out::println, repository).process(args[0]);
    }

}
