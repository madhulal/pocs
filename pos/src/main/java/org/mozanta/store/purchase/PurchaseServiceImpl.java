package com.mozanta.store.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozanta.store.common.repository.PurchaseRepository;
import com.mozanta.store.common.repository.StockRepository;
import com.mozanta.store.entity.Purchase;
import com.mozanta.store.entity.Stock;

@Service("PurchaseService")
public class PurchaseServiceImpl implements PurchaseService {

	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public void productPurchase(Purchase purchase) {
		
		Stock stock=new Stock();
		stock.setBatchNumber(purchase.getBatchNumber());
		stock.setExpiryDate(purchase.getExpiryDate());
		stock.setId(purchase.getId());
		stock.setMrp(purchase.getMrp());
		stock.setProduct(purchase.getProduct());
		stock.setPurchasePrice(purchase.getPurchasePrice());
		stock.setSellingPrice(purchase.getSellingPrice());
		stock.setStock(purchase.getStock());
		
		purchaseRepository.save(purchase);
		
		stockRepository.save(stock);
		
		
	}

}
