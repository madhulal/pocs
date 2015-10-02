import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class Purchase{
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		this.Purchase={};
		this.id='';
		this.product1='';
		this.batchNumber='';
		this.purchasePrice='';
		this.sellingPrice='';
		this.mrp='';
		this.expiryDate='';
		this.stock='';
		this.http=http;
	}
	
	getProductList()
	{
		this.http.createRequest('/store/rest/ProductList')
	       .asGet()
	       .withHeader('Content-Type','application/json')
	       .withParams()
	       .send()
	       .then( response => { 
	       	
	        this.productList=response.content;	
	        
	       	
	       });

	}
	purchase()
	{
		
		// this.Purchase.id='';
		 this.Purchase.batchNumber=this.batchNumber;
		 this.Purchase.purchasePrice=this.purchasePrice;
		 this.Purchase.product=this.product1;
		 this.Purchase.sellingPrice=this.sellingPrice;
		 this.Purchase.mrp=this.mrp;
		 this.Purchase.expiryDate=this.expiryDate;
		 this.Purchase.stock=this.stock;
		
		 this.http.createRequest('/store/rest/Purchase')
     .asPost()
     .withHeader('Content-Type','application/json')
     .withContent(this.Purchase)
     .send()
     .then( response => { 
     //	this.Organization=response.content;	
     })
     .catch( error=>{console.log("erroroccured")});
		 console.log("haiiiiiiiiiiiiiiiiiiiiiiii"+this.product)
	}
	}
