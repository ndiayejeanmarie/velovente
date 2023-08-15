package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Stock;
import sn.edu.ugb.ipsl.velovente.model.StockPK;
import sn.edu.ugb.ipsl.velovente.services.StockService;

import java.io.Serializable;
import java.util.List;

@Named("stockBeans")
@ViewScoped
public class StockBeans implements Serializable {

    @EJB
    private StockService stockService; // Vous devrez créer cette classe de service

    private Stock stock = new Stock();
    private List<Stock> stocks;

    public Stock getStock() {
        return stock;
    }

    public List<Stock> getStocks() {
        if (stocks == null) {
            stocks = stockService.findAll();
        }
        return stocks;
    }

    public Stock getStockById(StockPK stockPK) {
        return stockService.findById(stockPK.getMagasinId(),stockPK.getProduitId());
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de StockBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("### Suppression de StockBeans" + stock);
    }

    public void create() {
        stockService.saveStock(stock);
        stock = new Stock();
    }

    public void delete() {
        stockService.deleteStock(stock);
    }

    public void update() {
        stockService.updateStock(stock);
    }
}
