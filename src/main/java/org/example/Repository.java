package org.example;

public class Repository {
    private Product[] products = new Product[0];
    protected Repository(Product[] products) {
        this.products = products;
    }

    protected Product[] findAll() {
        return products;
    }

    protected void saveProduct(Product product) {
        Product[]  tmp = new Product[products.length + 1];
        int cnt = 0;
        for (Product prod: products
             ) {
            tmp[cnt] = prod;
            cnt++;
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    protected void delProduct(int idProduct){
        Product[] tmp = new Product[products.length - 1];
        int cnt = 0;
        for (Product prod: products
             ) {
            if (prod.getId() != idProduct) {
                tmp[cnt] = prod;
                cnt++;
            }
        }
        products = tmp;
    }
}
