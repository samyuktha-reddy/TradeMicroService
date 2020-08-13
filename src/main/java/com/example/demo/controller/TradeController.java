package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TradeEntity;
import com.example.demo.repository.TradeRepository;

@RestController
@RequestMapping(value = "/trades")
public class TradeController {
	@Autowired
	public TradeRepository tradeRepo;
	Logger logger = LoggerFactory.getLogger(TradeController.class);

	@PostMapping(value = "/createTrade")
	public ResponseEntity<?> createNewTrade(@RequestBody TradeEntity trdEntity) {
		try {
			logger.debug("Got Incoming Request with the data:"+trdEntity.toString());
			TradeEntity obj1 = tradeRepo.save(trdEntity);
			logger.info("created the Trade Entity with primary key:"+obj1.getId());
			return new ResponseEntity<TradeEntity>(obj1, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/viewById/{id}")
	public ResponseEntity<?> getTradeById(@PathVariable int id) {

		try {
			Optional<TradeEntity> result = tradeRepo.findById(id);
			if (result.isPresent()) {
				return new ResponseEntity<TradeEntity>(result.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No Entity found ", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/findAllTrades")
	public List<TradeEntity> getAllTrades() {
		List<TradeEntity> obj2 = tradeRepo.findAll();
		return obj2;
	}

	@DeleteMapping(value = "deleteTradesbyId/{id}")
	public void deleteTradeById(int id) {
		tradeRepo.deleteById(id);
	}

	@GetMapping(value = "/getByStockSymbol")
	public ResponseEntity<?> getBySymbol(String tradeSymbol) {
		Optional<TradeEntity> obj3 = tradeRepo.findByStockSymbol(tradeSymbol);

		if (obj3.isPresent()) {
			return new ResponseEntity<TradeEntity>(obj3.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Entity found ", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/getByStockType")
	public ResponseEntity<?> getBystockType(String stockType) {
		List<TradeEntity> obj4 = tradeRepo.findByStockType(stockType);
		if (!obj4.isEmpty()) {
			return new ResponseEntity<List<TradeEntity>>(obj4, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Entities found ", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value ="/getstockByPrice")
	public ResponseEntity<?> getStockByPrice(double stockPrice)
	{
		List<TradeEntity> obj5 = tradeRepo.findByTradePrice(stockPrice);
		if(obj5.isEmpty())
			{
			return new ResponseEntity<String>("No entities are found with the given price", HttpStatus.BAD_REQUEST);
			}
		else
		{
			return new ResponseEntity<List<TradeEntity>>(obj5, HttpStatus.OK);
			
		}
			}

}
